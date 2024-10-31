# Sistema de Gestão de Coleta de Lixo e Recicláveis

## 1. Visão Geral do Projeto

**Objetivo**: Desenvolver um sistema para gerenciar a coleta de materiais recicláveis, otimizando processos operacionais, incentivando o engajamento dos cidadãos e aprimorando a coleta de dados para análises e melhorias contínuas.

**Principais Funcionalidades**: Cadastro de materiais e pontos de coleta, criação de rotas otimizadas, sistema de login e permissões, coleta de feedback dos usuários, consulta ao histórico de coletas por região, geração de relatórios, visualização de estatísticas de reciclagem e gamificação para incentivar o engajamento.

---

## 2. Requisitos Funcionais

### 2.1 Cadastro e Gerenciamento de Materiais Recicláveis
- **RF-01**: O sistema deve permitir o cadastro de diferentes tipos de materiais recicláveis (ex.: papel, plástico, vidro, metal).
- **RF-02**: O administrador deve poder atualizar informações dos materiais cadastrados, incluindo características e métodos de coleta.
- **RF-03**: O sistema deve permitir a remoção de materiais, contanto que não estejam atrelados a registros históricos.

### 2.2 Cadastro e Gerenciamento de Pontos de Coleta
- **RF-04**: O sistema deve permitir o cadastro de pontos de coleta com informações de endereço, tipo de material aceito e horário de funcionamento.
- **RF-05**: O administrador deve poder visualizar todos os pontos de coleta em um mapa interativo.
- **RF-06**: O sistema deve permitir a atualização dos dados dos pontos de coleta.
- **RF-07**: O administrador deve poder desativar pontos de coleta temporariamente ou removê-los permanentemente.

### 2.3 Sistema de Login e Gerenciamento de Usuários
- **RF-08**: O sistema deve incluir um mecanismo de autenticação por login e senha.
- **RF-09**: Deve haver diferentes níveis de permissão: administrador, operador de coleta e cidadão.
- **RF-10**: Administradores devem poder cadastrar, atualizar e excluir usuários, definindo o perfil de cada um.
- **RF-11**: O sistema deve permitir a recuperação de senha por e-mail para todos os tipos de usuários.

### 2.4 Criação e Otimização de Rotas de Coleta
- **RF-12**: O sistema deve permitir a criação de rotas de coleta com base na localização dos pontos e no volume de material.
- **RF-13**: O administrador deve poder otimizar as rotas usando algoritmos de geolocalização e distância mínima.
- **RF-14**: O sistema deve permitir o redirecionamento de rotas em tempo real, notificando os operadores de coleta sobre mudanças.

### 2.5 Geração de Relatórios e Estatísticas
- **RF-15**: O sistema deve permitir a geração de relatórios de coleta com dados como volume coletado, tipo de material, região e frequência.
- **RF-16**: O sistema deve fornecer estatísticas visuais (gráficos e tabelas) sobre os tipos de materiais reciclados e volume mensal.
- **RF-17**: Os relatórios devem ser exportáveis em formatos como PDF e Excel.

### 2.6 Sistema de Feedback dos Usuários
- **RF-18**: Cidadãos devem poder enviar feedback sobre os pontos de coleta e o serviço de coleta em geral.
- **RF-19**: Administradores devem poder visualizar e responder ao feedback dos usuários.

### 2.7 Histórico de Coletas por Região
- **RF-20**: O sistema deve armazenar um histórico detalhado das coletas por região, com data, tipo de material e volume coletado.
- **RF-21**: O operador de coleta e o administrador devem poder consultar o histórico de coletas em uma região específica.

### 2.8 Notificações e Alertas
- **RF-22**: O sistema deve enviar notificações automáticas sobre coletas programadas, rota atualizada, e alertas de ponto de coleta cheio.
- **RF-23**: O sistema deve permitir que o usuário configure preferências de notificação (e-mail, SMS, push).

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

## 4. Suposições e Restrições

### Suposições
- O sistema será acessado principalmente por usuários com dispositivos móveis e internet de média velocidade.
- A integração de APIs de geolocalização e notificações (ex.: Google Maps, Twilio) será viável e econômica.

### Restrições
- O sistema deve operar em conformidade com a Lei Geral de Proteção de Dados (LGPD), armazenando dados pessoais com consentimento e em locais seguros.
- Operações em tempo real devem ser limitadas aos recursos disponíveis e aos serviços de rede na região de atuação.

---

## 5. Priorização dos Requisitos

1. **Alta Prioridade**: Cadastro de Materiais e Pontos de Coleta, Sistema de Login e Permissões, Criação de Rotas de Coleta, Histórico de Coletas por Região.
2. **Média Prioridade**: Relatórios de Coletas, Feedback dos Usuários, Sistema de Notificações e Alertas.
3. **Baixa Prioridade**: Estatísticas de Reciclagem.

---
