# 💰 Finexa

Sistema desktop desenvolvido em Java para gerenciamento financeiro pessoal, com controle de receitas, despesas e saldo.

---

## 📌 Funcionalidades

* 🔐 Login de usuário
* 💸 Cadastro de despesas
* 💰 Cadastro de receitas
* 📊 Dashboard com:

  * Saldo atual
  * Total de receitas
  * Total de despesas
* 📜 Histórico de transações
* ⚙️ Atualização de dados do usuário (nome, e-mail, senha e tipo)

---

## 🛠️ Tecnologias utilizadas

* Java (Swing)
* MySQL
* JDBC
* NetBeans IDE
* Git e GitHub

---

## 🗄️ Banco de dados

O sistema utiliza um banco MySQL com as seguintes tabelas principais:

### 👤 usuarios

* id_usuario (PK)
* nome
* email
* senha
* tipo_usuario

### 💸 despesas

* id_despesa (PK)
* descricao
* valor
* data_pagamento
* forma_pagamento
* id_usuario (FK)
* id_categoria (FK)

### 💰 receitas

* id_receita (PK)
* descricao
* valor
* data_recebimento
* id_usuario (FK)
* id_fonte (FK)
* id_categoria (FK)

---

## ▶️ Como executar o projeto

1. Clone o repositório:

```
git clone https://github.com/SEU-USUARIO/Finexa.git
```

2. Abra o projeto no NetBeans

3. Configure o banco de dados MySQL:

   * Crie o banco
   * Execute os scripts das tabelas
   * Ajuste usuário e senha no arquivo `Conexao.java`

4. Execute a aplicação pela classe `LoginView`

---

## 🔑 Usuário para teste

Use o seguinte login para acessar o sistema:

* Email: [admin@finexa.com](mailto:admin@finexa.com)
* Senha: 123456

---

## 📌 Observações

* O sistema permite cadastro de receitas e despesas com associação ao usuário logado
* O dashboard é atualizado automaticamente com base nos dados do banco
* O histórico exibe todas as transações registradas

---

## 👨‍💻 Autor

Gabriel da Cunha Silva Soares

---

## 📎 Projeto acadêmico

Desenvolvido para fins educacionais com foco em:

* Programação orientada a objetos
* Integração com banco de dados
* Versionamento com Git
