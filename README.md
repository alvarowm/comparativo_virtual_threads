# Comparação de Desempenho: Leitura de Arquivos CSV com e sem Virtual Threads

Este projeto demonstra uma comparação simples de desempenho entre a execução sequencial e a execução paralela (usando **Virtual Threads**) ao ler múltiplos arquivos CSV.

## 📌 Visão Geral

O programa realiza duas etapas principais:

1. **Execução sequencial**: Lê 10 arquivos CSV um após o outro, medindo o tempo total.
2. **Execução paralela com Virtual Threads**: Utiliza um `ExecutorService` com um pool de threads fixo (10 threads) configurado com `ThreadFactory` de **Virtual Threads** (disponível a partir do Java 21) para ler os mesmos arquivos simultaneamente.

Ao final, imprime os tempos de execução de ambas as abordagens, permitindo observar os ganhos (ou não) de desempenho com o uso de concorrência leve.

## 🛠 Requisitos

- **Java 21 ou superior** (necessário para suporte a Virtual Threads)
- Arquivos CSV nomeados de forma compatível com a lógica de `CSVHandler.lerArquivo(int index)` (ex: `arquivo0.csv`, `arquivo1.csv`, etc.)
- IDE ou terminal com suporte à compilação e execução de aplicações Java

## 📂 Estrutura do Projeto

- `Main.java`: Classe principal que orquestra a comparação de desempenho.
- `CSVHandler.java`: Classe responsável por ler os arquivos CSV.
