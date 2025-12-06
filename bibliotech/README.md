# Integração de API REST — exemplo local

Este repositório contém um exemplo simples para testar a integração entre um formulário (`cadastro.html`) e uma API REST local (Express).

Passos rápidos (Windows / PowerShell):

1. Instalar dependências do servidor:

```powershell
cd "c:\Users\yan3cti\Documents\bibliotech\projeto"
npm install
```

2. Iniciar o servidor da API (ou use o depurador do VS Code):

```powershell
npm start
# ou abra o painel Run/Debug e escolha "Launch API (server.js)"
```

3. Servir o front-end (`cadastro.html`):

- Recomendado: instale a extensão Live Server no VS Code e clique em "Go Live" no canto inferior direito. Isso serve os arquivos estáticos em `http://127.0.0.1:5500` (ou porta configurada) e evita problemas de CORS por `file://`.

4. Testar o cadastro: abra `cadastro.html` via Live Server, preencha o formulário e envie. O frontend fará um POST para `http://localhost:8080/api/register`.

Observações:
- O servidor aqui é apenas para demonstração (dados em memória). Não use em produção.
- Se preferir, use o `REST Client` ou `Thunder Client` para testar endpoints diretamente.
