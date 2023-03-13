# pipe2brains
Desafio C: Como acelerar o processo de abertura de empresas

11/03/23 - 
Primeiras implementações página de validações do usuário
Rascunhos e coletas iniciais de informações
 
13/03/23 - API ficticia /consultacpf
Opções: GET - / - Retorna lista com todos os dados dos individuo contidos no objeto Listas
        GET - /(cpf) - Retorna objeto contendo os dados de um individuo por CPF

14/03/23 - API ficticia /consultaviabilidadepmb
Opções: GET - / - Retorna lista com todos os cadastros de IPTU contidos no objeto Listas
         GET - /(cadiptu) - Retorna objeto contendo os dados de IPTU de um registro pelo nr de cadastro
         POST - / - Envia objeto json contendo dados necessário para consulta de viabilidade e retorna:
              1 - Viabilidade OK
              2 - Atividade não permitida no local
              3 - Cadastro com restrição
              4 - Cadastro inválido
