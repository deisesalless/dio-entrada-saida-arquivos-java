# Exercícios sobre o aprendizado do pacote `java.io`

Este repositório contém exercícios e anotações sobre o uso do pacote `java.io` para manipulação de entrada e saída (I/O) em Java, focando em **Bytes** e **Caracteres**.

---

## Resumo do que aprendi

### Streams em Java

As streams no Java são divididas em duas categorias principais:

#### 1. Bytes
- **Classes Base**: `InputStream` e `OutputStream`.
- **Subcategorias**: `Data`, `Object`, etc.
- **Versão**: Disponível desde o Java 1.
- **Características**:
  - Leitura byte a byte.
  - Não faz tudo que as streams de caracteres fazem.
  - **Desvantagem**: Lento para arquivos grandes, pois lê byte por byte.

#### 2. Caracteres
- **Classes Base**: `Reader` e `Writer`.
- **Versão**: Disponível a partir do Java 1.1.
- **Características**:
  - Faz tudo que as streams de bytes fazem, mas com melhor desempenho.
  - Leitura de caracteres usando o padrão Unicode (2 bytes por caractere).
  - **Vantagem**: Mais eficiente para arquivos grandes, pois lê 2 bytes por vez.

---

### Fluxos pré-definidos de entrada
- `System.in`
- `Scanner`
- `InputStream`
- `BufferedReader`

### Fluxos pré-definidos de saída
- `System.out`
- `System.err`
- `PrintWriter`

---

### Considerações
- **Bytes**: Lento e ineficiente para arquivos grandes, mas útil para operações de baixo nível.
- **Caracteres**: Mais eficiente e recomendado para a maioria dos casos, especialmente quando se lida com texto.

---

## Objetivo dos Exercícios
- Praticar a manipulação de arquivos e streams usando `java.io`.
- Entender as diferenças entre streams de bytes e caracteres.
- Explorar as classes principais como `InputStream`, `OutputStream`, `Reader`, `Writer`, `BufferedReader`, `PrintWriter`, etc.

---

## Anotações Pessoais
- Sempre preferir streams de caracteres para manipulação de texto.
- Para arquivos binários (imagens, vídeos, etc.), streams de bytes são mais adequados.
- `BufferedReader` e `BufferedWriter` são ótimos para melhorar o desempenho em operações de I/O.
