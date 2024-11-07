# Sistema de Gestão de Coleta de Lixo e Recicláveis

## 1. Visão Geral do Projeto

**Objetivo**: Desenvolver um sistema para gerenciar a coleta de materiais recicláveis, otimizando processos operacionais, incentivando o engajamento dos cidadãos e aprimorando a coleta de dados para análises e melhorias contínuas.

**Principais Funcionalidades**: Cadastro de materiais e pontos de coleta, criação de rotas otimizadas, sistema de login e permissões, coleta de feedback dos usuários, consulta ao histórico de coletas por região, geração de relatórios, visualização de estatísticas de reciclagem e gamificação para incentivar o engajamento.

---

## 2. Requisitos Funcionais

### 2.1 Cadastro e Gerenciamento de Materiais

#### 2.1.1 Cadastrar Dados de Materiais
- **RF-01**: O sistema deve permitir o cadastro de materiais.

#### 2.1.2 Editar Dados de Materiais
- **RF-02**: O sistema deve permitir a edição dos dados de materiais.

#### 2.1.3 Excluir Dados de Materiais
- **RF-03**: O sistema deve permitir a exclusão de materiais.


### 2.2 Cadastro e Gerenciamento de Pontos de Coleta

#### 2.2.1 Cadastrar de Pontos de Coleta
- **RF-04**: O sistema deve permitir o cadastro de pontos de coleta dentro de rotas.

#### 2.2.2 Editar Pontos de Coleta
- **RF-05**: O sistema deve permitir a edição dos pontos de coleta.

#### 2.2.3 Excluir Pontos de coleta
- **RF-06**: O sistema deve permitir a exclusão de pontos de coleta.

#### 2.2.4 Vizualizar Pontos de coleta
- **RF-07**: O sistema deve permitir a vizualização dos pontos de coleta.


### 2.3 Sistema de Login e Gerenciamento de Usuários

#### 2.3.1 Cadastrar Dados de Administrador
- **RF-08**: O sistema deve permitir o cadastro de um administrador para o controle de suas funcionalidades.

#### 2.3.2 Editar Dados de Administrador
- **RF-09**: O sistema deve permitir a edição dos dados do administrador do sistema para o controle de acesso em situações de sua alteração.

#### 2.3.3 Cadastrar Dados de Supervisor
- **RF-10**: O sistema deve permitir o cadastro de usuários do tipo supervisor pelo administrador do sistema para o controle de seu acesso.

#### 2.3.4 Editar Dados de Supervisor
- **RF-11**: O sistema deve permitir a edição dos dados do usuário supervisor.

#### 2.3.5 Desativar Supervisor
- **RF-12**: O sistema deve permitir a desativação de usuários do tipo supervisor pelo administrador do sistema para o controle de seu acesso.

#### 2.3.6 Cadastrar Dados de Operador
- **RF-13**: O sistema deve permitir o cadastro de usuários do tipo operador pelo supervisor e administrador do sistema para o controle de seu acesso.

#### 2.3.7 Editar Dados de Operador
- **RF-14**: O sistema deve permitir a edição dos dados do usuário operador.

#### 2.3.8 Desativar Operador
- **RF-15**: O sistema deve permitir a desativação de usuários do tipo operador pelo supervisor e administrador do sistema para o controle de seu acesso.

#### 2.3.9 Cadastrar Dados de Cidadão
- **RF-16**: O sistema deve permitir o cadastro de usuários do tipo cidadão para o controle de suas funcionalidades.

#### 2.3.10 Editar Dados de Cidadão
- **RF-17**: O sistema deve permitir a edição dos dados do usuário cidadão.

#### 2.3.11 Desativar Cidadão
- **RF-18**: O sistema deve permitir a desativação do usuário cidadão.

#### 2.3.12 Recuperar Acesso
- **RF-19**: O sistema deve permitir a recuperação de senha via email.


### 2.4 Criação e Otimização de Rotas de Coleta

#### 2.4.1 Cadastrar de Rotas de Coleta
- **RF-20**: O sistema deve permitir o cadastro de rotas de coleta dentro de rotas.

#### 2.4.2 Editar Rotas de Coleta
- **RF-21**: O sistema deve permitir a edição dos rotas de coleta.

#### 2.4.3 Excluir Rotas de coleta
- **RF-22**: O sistema deve permitir a exclusão de rotas de coleta.

#### 2.4.4 Vizualizar Rotas de coleta
- **RF-23**: O sistema deve permitir a vizualização dos rotas de coleta.


### 2.5 Geração de Relatórios e Estatísticas

#### 2.5.1 Gerar Relatórios e Estatísticas
- **RF-24**: O sistema deve permitir a geração de relatórios e estatísticas de coletas.

#### 2.5.2 Vizualizar Relatórios e Estatísticas
- **RF-25**: O sistema deve permitir a vizualização dos relatórios e estatísticas de coletas.


### 2.6 Sistema de Feedback dos Usuários

#### 2.6.1 Criar feedbacks
- **RF-26**: O sistema deve permitir a criação de feedbacks nas coletas.

#### 2.6.2 Editar feedbacks
- **RF-27**: O sistema deve permitir a edição dos feedbacks.

#### 2.6.3 Excluir feedbacks
- **RF-28**: O sistema deve permitir a exclusão de feedbacks.

#### 2.6.4 Vizualizar feedbacks
- **RF-29**: O sistema deve permitir a vizualização dos feedbacks nas coletas.


### 2.7 Histórico de Coletas por Região

#### 2.7.1 Gerar Histórico
- **RF-30**: O sistema deve gerar o histórico das coletas automaticamente.

#### 2.7.2 Vizualizar Histórico
- **RF-31**: O sistema deve permitir a vizualização do histórico das coletas.

### 2.8 Notificações e Alertas
- **RF-32**: O sistema deve enviar notificações automáticas sobre coletas programadas, rota atualizada, e alertas de ponto de coleta cheio.
- **RF-33**: O sistema deve permitir que o usuário configure preferências de notificação (e-mail, SMS).

---

## 3. Requisitos Não Funcionais

### 3.1 Usabilidade
- **RNF-01**: A interface deve ser amigável, com elementos visuais intuitivos, e acessível a usuários com diferentes perfis técnicos.
- **RNF-02**: O sistema deve ser responsivo e suportar navegação em dispositivos móveis.

### 3.2 Desempenho
- **RNF-03**: O sistema deve carregar dados e gerar relatórios em até 3 segundos para consultas básicas.
- **RNF-04**: Notificações em tempo real devem ser enviadas aos operadores de coleta em até 5 segundos após uma alteração.

### 3.3 Segurança
- **RNF-05**: O sistema deve proteger as informações dos usuários utilizando criptografia para senhas e dados sensíveis.
- **RNF-06**: O sistema deve realizar o log de atividades administrativas e de coleta para auditoria e segurança.

### 3.4 Escalabilidade
- **RNF-07**: O sistema deve suportar o aumento de pontos de coleta e rotas sem comprometer o desempenho.
- **RNF-08**: A arquitetura deve permitir o aumento da quantidade de usuários sem impacto perceptível para o usuário final.

### 3.5 Disponibilidade
- **RNF-09**: O sistema deve ser acessível 99,9% do tempo, com exceção de manutenções programadas.

### 3.6 Compatibilidade
- **RNF-10**: O sistema deve ser compatível com os navegadores Chrome, Firefox, Safari e Edge nas últimas versões.

---

## 4. Usuários do Sistema

### Administrador
O administrador do sistema é o usuário que apresenta a função de controlar o sistema como um todo, com permissão para acessar todas as funcionalidades.

#### Dados Requeridos pelo Sistema
- Nome
- CPF/CNPJ
- Email
- Endereço (rua, bairro, cidade, estado)
- CEP
- Telefone

### Supervisor
O supervisor é o usuário responsável pelas rotas, pontos de coletas, materiais e as coletas, sendo o responsável por cadastrar e administrar essas funcionalidades.

#### Dados Requeridos pelo Sistema
- Nome
- CPF
- Email
- Endereço (rua, bairro, cidade, estado)
- CEP
- Telefone
- Departamento de supervisão

### Operador
O operador é o usuário que acessa as informações de rotas, pontos de coletas e materiais para percorrer as rotas e coletar os materiais nos pontos cadastrados, entregabndo-os ao supervisor poara contabilizá-los.

#### Dados Requeridos pelo Sistema
- Nome
- CPF
- Email
- Endereço (rua, bairro, cidade, estado)
- CEP
- Telefone
- Departamento 

### Cidadão
O cidadão é o usuário que acessa as informações presentes no sistema, como as rotas, pontos de coleta e materiais, para depositar o seu lixo nos pontos de coleta antes do operador realizar a coleta.

#### Dados Requeridos pelo Sistema
- Nome
- CPF
- Email
- Endereço (rua, bairro, cidade, estado)
- CEP
- Telefone
 

---

## 5. Priorização dos Requisitos

1. **Alta Prioridade**: Cadastro de Materiais e Pontos de Coleta, Sistema de Login e Permissões, Criação de Rotas de Coleta, Histórico de Coletas por Região.
2. **Média Prioridade**: Relatórios de Coletas, Feedback dos Usuários, Sistema de Notificações e Alertas.
3. **Baixa Prioridade**: Estatísticas de Reciclagem.

---
