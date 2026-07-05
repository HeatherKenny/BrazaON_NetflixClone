## Como Executar o Projeto

Siga estes passos exatamente para rodar a aplicação:

### Passo 1: Abrir o Terminal na Pasta Correta
Vai na pasta da versão que você quer rodar agora (ex: `BrazaON_v5\v5`).

### Passo 2: Compilar e Rodar
No terminal, digite o comando abaixo:
- **No Windows (PowerShell ou CMD):**
  ```bash
  .\mvnw.cmd spring-boot:run
  ```
- **No Linux/Mac:**
  ```bash
  ./mvnw spring-boot:run
  ```

### Passo 3: Acessar no Navegador
**IMPORTANTE**: Não digite o endereço `http://localhost:8080` no terminal. O terminal é só pra deixar o servidor rodando, não precisa mexer lá.
1. Espera até aparecer aquela mensagem de sucesso no terminal: `Started BrazaONApplication in ... seconds`.
2. Abra o seu **Navegador de Internet** (Chrome, Edge, Firefox).
3. Aí é só abrir o navegador e digitar isso aqui:
   ```text
   http://localhost:8080
   ```

## 3. Configuração da API TMDb

Para que os filmes apareçam, você precisa de uma chave da API do TMDb:
1. Abra o arquivo `src/main/java/com/BrazaON/service/TmdbService.java`.
2. Substitua `YOUR_API_KEY_HERE` pela sua chave real.
3. Ou adicione ao `application.yml`:
   ```yaml
   tmdb:
     api:
       key: SUA_CHAVE_AQUI
   ```

---
*Dica: Se o comando `.\mvnw.cmd` falhar por "permissão de execução", tente rodar o terminal como Administrador.*
