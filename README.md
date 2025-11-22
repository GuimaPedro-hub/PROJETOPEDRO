# 📚 Sistema de Gestão Escolar em Java

Sistema de Gestão Escolar desenvolvido em Java com foco inicial em aplicação console.  
O objetivo é gerenciar informações escolares como **alunos, disciplinas, turmas e notas**, servindo tanto como projeto acadêmico quanto como portfólio de desenvolvimento backend.

---

## 🎯 Objetivos do projeto

**Objetivo geral**

- Desenvolver um sistema de gestão escolar em Java que permita o gerenciamento básico de alunos, disciplinas, turmas e notas.

**Objetivos específicos**

- Aplicar conceitos de **Programação Orientada a Objetos** na modelagem do domínio escolar.
- Criar uma aplicação funcional em **modo console**, com menus e navegação por opções.
- Utilizar **coleções em memória** (`List`, `Map`) para armazenamento inicial dos dados.
- Implementar **tratamento de erros e exceções** para tornar o sistema mais robusto.
- Introduzir **persistência em arquivos de texto**, permitindo manter os dados entre execuções.
- Organizar o código em **pacotes e camadas** para facilitar manutenção e evolução.
- Preparar o sistema para futuras expansões com **banco de dados**, **interface gráfica** e **API REST**.

---

## ✨ Funcionalidades

Versões iniciais do sistema contemplam:

- Cadastro de **alunos**  
  - nome  
  - e-mail  
  - matrícula  

- Cadastro de **disciplinas**  
  - nome  
  - carga horária  

- Criação de **turmas** vinculadas a uma disciplina  
  - nome da turma  
  - ano  
  - semestre  

- Matrícula de **alunos em turmas**

- Lançamento de **notas** para alunos em turmas  
  - aluno  
  - turma  
  - tipo de avaliação  
  - valor da nota  

- Consulta de **boletim** de um aluno  
  - turmas  
  - disciplinas  
  - notas lançadas  

- Persistência em **arquivos de texto**  
  - salvar e carregar dados de alunos, disciplinas, turmas e notas

---

## 📌 Escopo

**Incluído nas versões iniciais**

- Cadastro, listagem e consulta de:
  - alunos
  - disciplinas
  - turmas
  - notas
- Matrícula de alunos em turmas.
- Consulta de boletim.
- Aplicação em modo console.
- Armazenamento em coleções em memória.
- Persistência simples em arquivos de texto.

**Fora do escopo neste momento (planejado para o futuro)**

- Relatórios avançados e gráficos.
- Sistema de login e autenticação.
- Interface gráfica com **JavaFX**.
- API REST com **Spring Boot**.
- Integração com banco de dados usando **JDBC/JPA**.

---

## 🧱 Requisitos

**Requisitos funcionais principais**

- Cadastro e listagem de alunos.
- Cadastro e listagem de disciplinas.
- Criação de turmas vinculadas a disciplinas.
- Matrícula de alunos em turmas.
- Lançamento de notas por aluno e turma.
- Consulta de boletim de um aluno.
- Persistência dos dados em arquivos de texto.

**Requisitos não funcionais**

- Linguagem: **Java**.
- IDE sugerida: **IntelliJ IDEA**.
- Interface inicial em **modo console**.
- Código organizado em **pacotes e camadas**.
- Tratamento de erros de entrada de dados para evitar interrupções inesperadas.
- Persistência em arquivos de texto para restaurar dados entre execuções.

---

## 🧬 Modelagem do domínio

**Entidade `Aluno`**

Representa um estudante cadastrado no sistema.

- `id: Integer`
- `nome: String`
- `email: String`
- `matricula: String`

**Entidade `Disciplina`**

Representa uma disciplina oferecida pela instituição.

- `id: Integer`
- `nome: String`
- `cargaHoraria: Integer`

**Entidade `Turma`**

Representa a oferta de uma disciplina em determinado ano e semestre.

- `id: Integer`
- `nome: String`
- `ano: Integer`
- `semestre: Integer`
- `disciplina: Disciplina`
- `alunosMatriculados: List<Aluno>`

**Entidade `Nota`**

Representa uma avaliação atribuída a um aluno em uma turma.

- `aluno: Aluno`
- `turma: Turma`
- `tipo: TipoAvaliacao`
- `valor: Double`

**Enum `TipoAvaliacao`**

- `PROVA`
- `TRABALHO`
- `PARTICIPACAO`

---

## 🏛 Arquitetura do sistema

Na versão console, a sugestão de organização é:

- Pacote `application`  
  - Contém a classe principal responsável por iniciar o sistema e o menu.

- Pacote `model.entities`  
  - Contém as classes de domínio  
    - `Aluno`, `Disciplina`, `Turma`, `Nota`, `TipoAvaliacao`.

- Pacote `model.exceptions`  
  - Exceções personalizadas para regras de negócio e validações.

- Pacote `model.persistence`  
  - Responsável pela leitura e gravação em arquivos de texto.

- Pacote `model.services`  
  - Regras de negócio, como matrícula de alunos, lançamento de notas etc.

**Fases previstas**

- Fase 1  
  - Aplicação totalmente em console.  
  - Dados em coleções em memória.  
  - Funcionalidades básicas de cadastro, listagem, matrícula, notas e boletim.

- Fase 2  
  - Tratamento robusto de exceções.  
  - Persistência completa em arquivos de texto.

- Fases futuras  
  - Banco de dados relacional.  
  - Interface gráfica em JavaFX.  
  - API REST com Spring Boot.

---

## 🔁 Fluxos principais de uso

- **Cadastro de aluno**  
  O usuário escolhe a opção de cadastro, informa os dados solicitados e o sistema cria um novo registro na lista de alunos.

- **Cadastro de disciplina**  
  O usuário informa nome e carga horária e o sistema cria uma nova disciplina.

- **Criação de turma**  
  O usuário seleciona uma disciplina existente e informa nome, ano e semestre para criar a turma.

- **Matrícula de aluno em turma**  
  O usuário escolhe um aluno e uma turma e o sistema adiciona o aluno à lista de matriculados daquela turma.

- **Lançamento de nota**  
  O usuário informa aluno, turma, tipo de avaliação e valor da nota. O sistema registra a nota associada a esse contexto.

- **Consulta de boletim**  
  O usuário seleciona um aluno e o sistema exibe suas turmas, disciplinas e notas em modo texto.
