# pipe2brains
Desafio C: Como acelerar o processo de abertura de empresas

11/03/23 - 
Primeiras implementações página de validações do usuário
Rascunhos e coletas iniciais de informações
 
13/03/23 - API ficticia /consultacpf
Opções: GET - / - Retorna lista com todos os dados dos individuo contidos no objeto Listas
        GET - /(cpf) - Retorna objeto contendo os dados de um individuo por CPF

14/03/23 - API ficticia /consultaviabilidadepmb
Opções:  GET - / - Retorna lista com todos os cadastros de IPTU contidos no objeto Listas
         GET - /(cadiptu) - Retorna objeto contendo os dados de IPTU de um registro pelo nr de cadastro
         POST - / - Envia objeto json contendo dados necessário para consulta de viabilidade e retorna:
              1 - Viabilidade OK
              2 - Atividade não permitida no local
              3 - Cadastro com restrição
              4 - Cadastro inválido

14/03/23 - API /viabilidadeMei (CRUD tabela TB_CADASTRO_MEI)
Opções: POST - /        - Registra um pacote json na tabela (atuamente não existe nenhum item obrigatório)
        GET - /         - Retorna lista com todos os cadastros de consulta MEI contidos na tabela
        GET - /(id)     - Retorna registro da tabela através do campo id
        DEL - /(id)     - Remove registro da tabela através do campo id
        PUT - /(id)     - Edita registro da tabela através do campo id
        Testes Gerais   - Evita cadastro duplicado testando se CPF já existe
                        - Evita que métodos GET, DEL e PUT sejam executados se registro não existir previamente

Observações: O arquivo racunhos/testesJsonMEI.txt possui 3 exemplos de cadastro utilizando a ferramenta Postman 