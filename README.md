# ☕ Java: Collections, Classes Utilitárias e Concorrência

<div align="center">

![Java](https://img.shields.io/badge/Java-21%20LTS-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Bootcamp](https://img.shields.io/badge/Bootcamp-DIO%20%7C%20Itaú-E60000?style=for-the-badge)

<p align="center">
  <b>Repositório de estudos práticos focado em Collections Framework, Streams API, manipulação de Strings, Classes Utilitárias, Tratamento de Exceções com DAO e Concorrência/Multithreading em Java moderno.</b>
</p>

<sub>Desenvolvido durante a trilha <b>Java com IA</b> da <b>Digital Innovation One (DIO)</b> em parceria com o <b>Itaú</b>.</sub>

</div>

---

## 📑 Sumário

- [📌 Sobre o Projeto](#-sobre-o-projeto)
- [🛠️ Tecnologias e Ferramentas](#️-tecnologias-e-ferramentas)
- [🧠 O que Aprendi e Implementei](#-o-que-aprendi-e-implementei)
  - [1. Java Collections Framework](#1-java-collections-framework)
  - [2. Classes Utilitárias e Precisão Numérica](#2-classes-utilitárias-e-precisão-numérica)
  - [3. Benchmark e Performance de Strings](#3-benchmark-e-performance-de-strings)
  - [4. Tratamento de Exceções e CRUD DAO em Console](#4-tratamento-de-exceções-e-crud-dao-em-console)
  - [5. Java Streams API & Records](#5-java-streams-api--records)
  - [6. Multithreading e Concorrência](#6-multithreading-e-concorrência)
- [📂 Estrutura do Projeto](#-estrutura-do-projeto)
- [🚀 Como Clonar e Executar (via Bash)](#-como-clonar-e-executar-via-bash)
  - [Pré-requisitos](#pré-requisitos)
  - [Passo a passo no Terminal](#passo-a-passo-no-terminal)
- [📄 Licença](#-licença)
- [👤 Autor](#-autor)

---

## 📌 Sobre o Projeto

Este repositório reúne um conjunto de exercícios práticos, provas de conceito (PoCs) e um mini-sistema de console desenvolvidos para aprofundar conhecimentos nos pilares centrais do desenvolvimento Java com a versão **Java 21 (LTS)**. 

O objetivo principal foi ir além da sintaxe básica, explorando:
- O comportamento interno das estruturas de dados.
- O impacto de performance na manipulação de memória (Strings).
- Boas práticas com `Optional` e cálculos de alta precisão com `BigDecimal`.
- Padrões arquiteturais limpos como **DAO** (Data Access Object) aliados a **Exceções Customizadas**.
- O poder expressivo da programação funcional com **Streams API**.
- Programação concorrente e controle de condições de corrida (Race Conditions).

---

## 🛠️ Tecnologias e Ferramentas

- **Linguagem:** Java 21 (LTS)
- **Paradigma:** Orientação a Objetos e Programação Funcional
- **Controle de Versão:** Git & GitHub
- **IDE Recomendada:** IntelliJ IDEA / Eclipse / VS Code

---

## 🧠 O que Aprendi e Implementei

### 1. Java Collections Framework
Exploração aprofundada das principais interfaces e implementações do pacote `java.util`:
- **`List` / `ArrayList`:** Manipulação ordenada e indexada de elementos, iterações funcionais com `forEach` e referências de métodos (`Method References`), métodos de acesso e remoção (`remove`, `getFirst`, `getLast`).
- **`Set` / `HashSet`:** Garantia de unicidade de dados sem repetições; entendimento prático do contrato **`equals()` e `hashCode()`** e iteração com `Iterator`.
- **`Map` / `HashMap`:** Associação chave-valor; inspeção de chaves (`keySet`) e valores (`values`); uso avançado da operação atômica **`merge()`** com funções lambda para atualização elegante de registros sem duplicidade.

### 2. Classes Utilitárias e Precisão Numérica
- **`BigDecimal` & `MathContext`:** Análise das limitações de ponto flutuante com tipos primitivos como `double` (arredondamentos imprecisos em operações financeiras) e implementação de operações aritméticas exatas (`add`, `subtract`, cálculo de raiz quadrada com `sqrt` e exponenciação fracionária).
- **`Optional<T>`:** Práticas para evitar o famigerado `NullPointerException` (NPE). Uso de `Optional.of()`, `Optional.empty()` e recuperação segura de valores de fallback com `orElse()`.

### 3. Benchmark e Performance de Strings
- Comparativo prático de desempenho medido em milissegundos (`Duration` e `OffsetDateTime`) executando 1.000.000 de iterações:
  - **`String`:** Imutável. Cada concatenação (`+=`) gera novas instâncias no heap, resultando em alto custo de tempo e memória ($O(N^2)$).
  - **`StringBuilder`:** Mutável e com buffer dinâmico. Ideal para manipulações pesadas em ambientes single-thread (altíssima velocidade).
  - **`StringBuffer`:** Mutável e thread-safe com métodos sincronizados, ideal para ambientes com múltiplas threads concorrentes.

### 4. Tratamento de Exceções e CRUD DAO em Console
Desenvolvimento de uma aplicação interativa em terminal com arquitetura limpa:
- **Exceções Customizadas:** Hierarquia com `CustomException`, `EmptyStoreException`, `UserNotFoundException` e `ValidatorException`.
- **Validação de Domínio:** Camada `UserValidator` com regras de validação para campos vazios/nulos, tamanho mínimo de nome e formato de e-mail.
- **Padrão DAO:** `UserDAO` com operações CRUD completas (`create`, `update`, `delete`, `findById`, `findAll`) operando sobre lista em memória com geração automática de IDs.
- **Controle de Fluxo:** Menu baseado em `Enum` (`MenuOption`) e manipulação robusta de erros com multi-catch (`catch (UserNotFoundException | EmptyStoreException e)`).

### 5. Java Streams API & Records
- Processamento declarativo e funcional de coleções de dados com pipelines de Streams.
- **Operações Intermediárias e Terminais:** `filter`, `map`, `flatMap`, `reduce`, `limit`, `peek`, `anyMatch`, `sorted` e `toList`.
- **Java Records:** Utilização de records imutáveis (`User`, `Contact`) e enums (`ContactType`, `Sex`) para modelagem limpa.
- **Transformação de Dados:** Agrupamento e formatação de saídas em formato JSON estruturado diretamente pelo stream.

### 6. Multithreading e Concorrência
- Criação e ciclo de vida de threads concorrentes com a interface funcional `Runnable` e classe `Thread`.
- **Prevenção de Race Conditions:** Sincronização de métodos compartilhados utilizando a palavra-chave `synchronized`.
- **Concorrência Lock-Free:** Uso de tipos atômicos do pacote `java.util.concurrent.atomic` (`AtomicInteger` com `incrementAndGet()` e `decrementAndGet()`) para controle atômico e de alta performance.

---

## 📂 Estrutura do Projeto

```text
dio-itau-CollectionsAndUtilityClasses/
│
├── .idea/                                  # Configurações do projeto no IntelliJ IDEA
├── src/                                    # Código-fonte da aplicação
│   └── com/
│       ├── collections/
│       │   ├── arraylistsetmap/            # List, Set, Map e contrato equals/hashCode
│       │   │   ├── ListAndArrayList.java
│       │   │   ├── ListSet.java
│       │   │   ├── MapHashMap.java
│       │   │   └── User.java
│       │   │
│       │   ├── bigdecimalandoptional/      # Precisão matemática e prevenção de NPE
│       │   │   ├── domain/
│       │   │   │   ├── ClassEnumSex.java
│       │   │   │   └── User.java
│       │   │   ├── MainBigDecimal.java
│       │   │   └── MainOptional.java
│       │   │
│       │   └── strings/                    # Comparativo de performance String vs Builders
│       │       └── TypeOfStrings.java
│       │
│       ├── exception/                      # Sistema CRUD interativo com Exceções Customizadas
│       │   ├── dao/
│       │   │   └── UserDAO.java
│       │   ├── exception/
│       │   │   ├── CustomException.java
│       │   │   ├── EmptyStoreException.java
│       │   │   ├── UserNotFoundException.java
│       │   │   └── ValidatorException.java
│       │   ├── model/
│       │   │   ├── MenuOption.java
│       │   │   └── UserModel.java
│       │   ├── validator/
│       │   │   └── UserValidator.java
│       │   └── Main.java                   # Menu CLI interativo
│       │
│       ├── streamsapi/                     # Pipelines de Streams e Java Records
│       │   ├── domain/
│       │   │   ├── Contact.java
│       │   │   ├── ContactType.java
│       │   │   ├── Sex.java
│       │   │   └── User.java
│       │   ├── MainStart.java
│       │   └── MainEnd.java
│       │
│       └── trheadrunnable/                 # Concorrência, Threads, Synchronized e AtomicInteger
│           ├── Main.java
│           └── Teste.java
│
├── LICENSE                                 # Licença MIT
└── README.md                               # Documentação do repositório
```

---

## 🚀 Como Clonar e Executar (via Bash)

### Pré-requisitos
Antes de começar, certifique-se de ter instalado em sua máquina:
- [Git](https://git-scm.com/)
- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) ou superior

Verifique as instalações no seu terminal:
```bash
git --version
java -version
javac -version
```

---

### Passo a passo no Terminal

#### 1. Clonar o repositório
Abra o seu terminal (Git Bash, WSL, terminal Linux/macOS ou PowerShell) e execute:
```bash
git clone https://github.com/Pedro-Ramon2608/dio-itau-CollectionsAndUtilityClasses.git
```

#### 2. Entrar no diretório do projeto
```bash
cd dio-itau-CollectionsAndUtilityClasses
```

#### 3. Compilar o projeto
Compile todas as classes Java para a pasta `out`:
```bash
# No Linux / macOS / Git Bash:
javac -d out $(find src -name "*.java")

# No Windows (PowerShell):
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
```

#### 4. Executar os programas

Você pode executar qualquer módulo individualmente passando o classpath `-cp out`:

- **Sistema de Usuários e Exceções (Menu Interativo):**
  ```bash
  java -cp out com.exception.Main
  ```

- **Benchmark de Desempenho de Strings:**
  ```bash
  java -cp out com.collections.strings.TypeOfStrings
  ```

- **Exemplos de Collections (List, Set ou Map):**
  ```bash
  java -cp out com.collections.arraylistsetmap.ListAndArrayList
  java -cp out com.collections.arraylistsetmap.ListSet
  java -cp out com.collections.arraylistsetmap.MapHashMap
  ```

- **Precisão com BigDecimal e Uso do Optional:**
  ```bash
  java -cp out com.collections.bigdecimalandoptional.MainBigDecimal
  java -cp out com.collections.bigdecimalandoptional.MainOptional
  ```

- **Processamento com Streams API:**
  ```bash
  java -cp out com.streamsapi.MainStart
  java -cp out com.streamsapi.MainEnd
  ```

- **Testes de Concorrência e Multithreading:**
  ```bash
  java -cp out com.trheadrunnable.Main
  java -cp out com.trheadrunnable.Teste
  ```

> [!TIP]
> Caso prefira utilizar uma IDE (como **IntelliJ IDEA**), basta abrir a pasta raiz do projeto. O IntelliJ detectará o diretório `src` e o JDK 21 automaticamente; depois, basta clicar no botão de execução (▶) ao lado de qualquer método `main`.

---

## 📄 Licença

Este projeto está sob a licença **MIT**. Consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.

---

## 👤 Autor

Desenvolvido por **Pedro Ramon Farias Lima de Jesus**.

- **GitHub:** [@Pedro-Ramon2608](https://github.com/Pedro-Ramon2608)
- **Repositório:** [dio-itau-CollectionsAndUtilityClasses](https://github.com/Pedro-Ramon2608/dio-itau-CollectionsAndUtilityClasses)

---
<div align="center">
  Feito com dedicação durante a trilha Java com IA 🚀
</div>
