# Atividades - Aula 12



### Atividade 1

1. Crie um projeto Java padrão e dê o nome de `Atividade 1`
2. Crie uma classe `Tarefa` com as seguintes variáveis de classe:
   1. `descricao`: `String`
   2. `finalizada`: `boolean`
   3. métodos `getters` e `setters`
3. Crie uma classe `Usuario ` com as seguintes variáveis de classe:
   1. `email`: `String`
   2. `senha`: `String`
   3. `tarefa`: `Tarefa`
   4. métodos `getters` e `setters` 
4. Na `main`, instancie um `ArrayList<Usuario>` para armazenar 3 usuários, usando laço de repetição. O programa deve pedir:
   1. email e senha para cada um dos usuários
   2. Criar uma tarefa para cada usuário
5. Faça um **outro** laço de repetição para apresentar as informações de cada um dos usuários: mostrar email, senha, a descrição da tarefa e se ela foi finalizada ou não.



**OBSERVAÇÕES:**

- Crie **apenas** um `ArrayList<Usuario>` na `main`
- **NÃO** crie um `ArrayList<Tarefa>` na `main`



---



### Atividade 2

1. Crie um projeto Java padrão e dê o nome de `Atividade 2`
2. Crie uma tarefa `Tarefa`:
   1. `descricao`: `String`
   2. `finalizada`: `boolean`
   3. métodos `getters` e `setters` 
3. Crie uma classe `Usuario`:
   1. `descricao`: `String`
   2. `finalizada`: `boolean`
   3. `tarefas`: `ArrayList<Tarefa>`
   4. métodos `getters` e `setters` 
4. Na `main`, instancie um `ArrayList<Usuario>` para armazenar 3 usuários. O programa deve pedir:
   1.  email e senha para cada um dos usuários
   2. três tarefas para cada um dos usuários
5. Depois, na `main`, apresente todas as informações de cada um dos usuários: email, senha e todas as tarefas



**OBSERVAÇÕES**

- Cada usuário deve ter sua própria lista de tarefas