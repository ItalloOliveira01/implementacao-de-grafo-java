import java.util.*;

public class Grafo {
    private Map<String, List<Aresta>> adjacencias;

    // Construtor
    public Grafo() {
        this.adjacencias = new HashMap<>();
    }

    // Classe interna para representar uma aresta com peso
    public static class Aresta {
        String destino;
        double peso;

        public Aresta(String destino, double peso) {
            this.destino = destino;
            this.peso = peso;
        }

        @Override
        public String toString() {
            return destino + " (" + peso + " km)";
        }
    }

    // Adiciona um vértice (local)
    public void adicionarVertice(String local) {
        adjacencias.putIfAbsent(local, new ArrayList<>());
    }

    // Adiciona uma aresta (conexão) entre dois locais
    public void adicionarAresta(String origem, String destino, double peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);
        adjacencias.get(origem).add(new Aresta(destino, peso));

        // Para grafo não direcionado, descomente a linha abaixo:
        // adjacencias.get(destino).add(new Aresta(origem, peso));
    }

    // Busca em largura (BFS) para encontrar o caminho mais curto (não ponderado)
    public List<String> buscarCaminhoBFS(String origem, String destino) {
        if (!adjacencias.containsKey(origem) || !adjacencias.containsKey(destino)) {
            return null;
        }

        Queue<String> fila = new LinkedList<>();
        Map<String, String> predecessores = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        fila.add(origem);
        visitados.add(origem);

        while (!fila.isEmpty()) {
            String atual = fila.poll();

            if (atual.equals(destino)) {
                break;
            }

            for (Aresta aresta : adjacencias.get(atual)) {
                String vizinho = aresta.destino;
                if (!visitados.contains(vizinho)) {
                    fila.add(vizinho);
                    visitados.add(vizinho);
                    predecessores.put(vizinho, atual);
                }
            }
        }

        // Reconstrução do caminho
        List<String> caminho = new LinkedList<>();
        String atual = destino;

        while (atual != null && predecessores.containsKey(atual)) {
            caminho.add(0, atual);
            atual = predecessores.get(atual);
        }

        if (!origem.equals(destino) && (atual == null || !atual.equals(origem))) {
            return null; // Caminho não encontrado
        }

        caminho.add(0, origem);
        return caminho;
    }

    // Busca em profundidade (DFS) a partir de um vértice
    public void buscarDFS(String origem) {
        Set<String> visitados = new HashSet<>();
        System.out.println("Iniciando DFS a partir de: " + origem);
        dfsRecursivo(origem, visitados);
    }

    private void dfsRecursivo(String atual, Set<String> visitados) {
        if (!adjacencias.containsKey(atual)) {
            System.out.println("Vértice não encontrado: " + atual);
            return;
        }

        visitados.add(atual);
        System.out.println("Visitando: " + atual);

        for (Aresta aresta : adjacencias.get(atual)) {
            String vizinho = aresta.destino;
            if (!visitados.contains(vizinho)) {
                dfsRecursivo(vizinho, visitados);
            }
        }
    }

    // Imprime a estrutura do grafo
    public void imprimirGrafo() {
        for (String local : adjacencias.keySet()) {
            System.out.print(local + " -> ");
            for (Aresta aresta : adjacencias.get(local)) {
                System.out.print(aresta + ", ");
            }
            System.out.println();
        }
    }

    // Retorna o mapa de adjacências
    public Map<String, List<Aresta>> getAdjacencias() {
        return adjacencias;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.adicionarAresta("A", "B", 5);
        grafo.adicionarAresta("A", "C", 3);
        grafo.adicionarAresta("B", "D", 2);
        grafo.adicionarAresta("C", "D", 4);
        grafo.adicionarAresta("D", "E", 1);

        System.out.println("Estrutura do Grafo:");
        grafo.imprimirGrafo();

        System.out.println("\nCaminho mais curto de A até E (BFS):");
        var caminho = grafo.buscarCaminhoBFS("A", "E");
        if (caminho != null) {
            System.out.println(String.join(" -> ", caminho));
        } else {
            System.out.println("Caminho não encontrado.");
        }

        System.out.println("\nExploração em profundidade (DFS) a partir de A:");
        grafo.buscarDFS("A");
    }
}
