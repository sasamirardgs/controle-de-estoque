class ProdEstoque:
    def __init__(self, cod, nome, preco, quantidade):
        self.cod = cod
        self.nome = nome
        self.preco = preco
        self.quantidade = quantidade

    def get_cod(self):
        return self.cod

    def get_nome(self):
        return self.nome

    def get_preco(self):
        return self.preco

    def get_quantidade(self):
        return self.quantidade

    def set_quantidade(self, quantidade):
        self.quantidade = quantidade


produtos = []

opcao = 0

while opcao != 6:
    print("\n===== CONTROLE DE ESTOQUE =====")
    print("1 - Cadastrar produto")
    print("2 - Consultar produto")
    print("3 - Entrada de produto")
    print("4 - Saída de produto")
    print("5 - Mostrar quantidade em estoque")
    print("6 - Sair")
    print("===============================")

    opcao = int(input("Escolha uma opção: "))

    if opcao == 1:
        cod = int(input("Digite o código do produto: "))
        nome = input("Digite o nome do produto: ")
        preco = float(input("Digite o preço do produto: "))
        quantidade = int(input("Digite a quantidade em estoque: "))

        produto = ProdEstoque(cod, nome, preco, quantidade)
        produtos.append(produto)

        print("Produto cadastrado com sucesso!")

    elif opcao == 2:
        nome_busca = input("Digite o nome do produto que deseja consultar: ")

        encontrado = False

        for produto in produtos:
            if produto.get_nome().lower() == nome_busca.lower():
                print("\nPRODUTO ENCONTRADO")
                print("Código:", produto.get_cod())
                print("Nome:", produto.get_nome())
                print("Preço: R$", produto.get_preco())
                print("Quantidade:", produto.get_quantidade())

                encontrado = True
                break
            

    elif opcao == 3:
        cod_busca = int(input("Digite o código do produto: "))
        encontrado = False

        for produto in produtos:
            if produto.get_cod() == cod_busca:
                quantidade_entrada = int(
                    input("Digite a quantidade que entrou no estoque: ")
                )

                if quantidade_entrada > 0:
                    nova_quantidade = produto.get_quantidade() + quantidade_entrada
                    produto.set_quantidade(nova_quantidade)

                    print("Entrada registrada com sucesso!")
                    print("Quantidade atual:", produto.get_quantidade())
                else:
                    print("A quantidade deve ser maior que zero!")

                encontrado = True
                break

        if encontrado == False:
            print("Produto não encontrado!")
            

    elif opcao == 4:
        cod_busca = int(input("Digite o código do produto: "))
        encontrado = False

        for produto in produtos:
            if produto.get_cod() == cod_busca:
                quantidade_saida = int(
                    input("Digite a quantidade que saiu do estoque: ")
                )

                if quantidade_saida > 0 and quantidade_saida <= produto.get_quantidade():
                    nova_quantidade = produto.get_quantidade() - quantidade_saida
                    produto.set_quantidade(nova_quantidade)

                    print("Saída registrada com sucesso!")
                    print("Quantidade restante:", produto.get_quantidade())

                elif quantidade_saida <= 0:
                    print("A quantidade deve ser maior que zero!")

                else:
                    print("Estoque insuficiente!")
                    print("Quantidade disponível:", produto.get_quantidade())

                encontrado = True
                break

        if encontrado == False:
            print("Produto não encontrado!")

    elif opcao == 5:
        if len(produtos) > 0:
            print("\nQUANTIDADE EM ESTOQUE")

            for produto in produtos:
                print("Código:", produto.get_cod())
                print("Produto:", produto.get_nome())
                print("Quantidade:", produto.get_quantidade())

        else:
            print("Nenhum produto cadastrado no estoque!")
            
print("Sistema encerrado!")
