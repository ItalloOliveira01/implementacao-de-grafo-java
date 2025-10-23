# Implementação de Grafo Ponderado em Java

Este projeto consiste em uma classe Java (`Grafo3`) que implementa uma estrutura de dados de grafo direcionado e ponderado. Os vértices são representados por `String` (indicando locais) e as arestas possuem pesos (indicando distância em "km").

O código inclui implementações dos algoritmos de busca em largura (BFS) e busca em profundidade (DFS).

## Funcionalidades

* **Estrutura do Grafo**: Utiliza um `HashMap` onde a chave é o vértice (String) e o valor é uma `List<Aresta>` (lista de adjacências).
* **Arestas Ponderadas**: Uma classe interna `Aresta` armazena o destino e o peso da conexão.
* **Adição de Vértices e Arestas**: Métodos `adicionarVertice(String local)` e `adicionarAresta(String origem, String destino, double peso)`.
* **Busca em Largura (BFS)**: O método `buscarCaminhoBFS(String origem, String destino)` encontra o caminho com o *menor número de arestas* (não o menor peso total) entre dois vértices.
* **Busca em Profundidade (DFS)**: O método `buscarDFS(String origem)` percorre o grafo em profundidade a partir de um vértice de origem e imprime a ordem de visitação.
* **Impressão do Grafo**: O método `imprimirGrafo()` exibe a lista de adjacência de cada vértice.

## Como Executar

Este projeto é um único arquivo Java. Para compilá-lo e executá-lo:

1.  **Salvar o arquivo**: Salve o código-fonte como `Grafo3.java`.
2.  **Compilar**: Abra um terminal no diretório do arquivo e execute:
    ```bash
    javac Grafo3.java
    ```
3.  **Executar**: Após a compilação, execute o programa:
    ```bash
    java Grafo3
    ```

## Saída Esperada

A execução do método `main` incluído no arquivo produzirá a seguinte saída:

Estrutura do Grafo: A -> B (5.0 km), C (3.0 km), B -> D (2.0 km), C -> D (4.0 km), D -> E (1.0 km), E ->

Caminho mais curto de A até E (BFS): A -> B -> D -> E

Exploração em profundidade (DFS) a partir de A: Iniciando DFS a partir de: A Visitando: A Visitando: B Visitando: D Visitando: E Visitando: C

🧠 Autor
Ítallo Gabriel de Oliveira Correia

💼 Estudante de Análise e Desenvolvimento de Sistemas

📍Focado em Java, lógica de programação e desenvolvimento de software limpo.
