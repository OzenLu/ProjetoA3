package com.mycompany.projetoA3;

import java.util.*;

/**
 * Equipe: nome: Daniel Lucas Silva Aragão RA: 12723214446
 *         nome: João Vitor Ribeiro        RA: 12724134755
 *         nome: Luan Cerqueira São Pedro  RA: 12724141297
 *         nome: Nalanda Carmo Santos      RA: 1272416149
 *
 * Projeto: Esse é um projeto de cadastro de produtos em um supermercado, que tem como opções cadastrar e listar produtos, fornecendo
 *  informações como: codigo, nome, data de fabricação, data de validade e preço, de forma ordenada a partir do código.
 *  Adicionalmente o programa também tem opções como modificar e excluir um produto.
 *  O programa inicia com 7 objetos sendo criados e adicionados ao ArrayList: listaDeProdutos.
 */
public class Principal {
    /*
     * Uma função que recebe como parametro um ArrayList e ao ser chamada, nos mostra uma lista de todos os objetos contidos
     * dentro dela.
     */
    public static void lista(ArrayList listaDeProdutos){
        System.out.println("CODIGO |  NOME  |  PREÇO");

        for (int y = 0; y < listaDeProdutos.size(); y++) {
            System.out.println(listaDeProdutos.get(y));
        }
    }

    public static void main(String[] args) {
        boolean codigoCadastrado = false;
        Scanner sc = new Scanner(System.in);
        ArrayList<Produtos> listaDeProdutos = new ArrayList();

        /*os parametros: nome, data de fabricacao, data de validade e preco estão sendo passados no construtor para a classe Produto.
            nome e preco estão sendo passados como parametro do construtor de Produto para a classe pai: Mercadoria.
         */
        Produtos item1 = new Produtos(1, "macarrao", "16/05/2024", "16/05/2025", 12.50, "Alimenticio", "Pacote 500g");
        Produtos item2 = new Produtos(2, "sabonete", "16/05/2024", "16/05/2025", 2.50, "Limpeza", "Unidade");
        Produtos item3 = new Produtos(3, "papel higienico", "16/05/2024", "16/05/2025", 10.99, "Limpeza", "Pacote");
        Produtos item4 = new Produtos(4, "agua sanitaria", "16/05/2024", "16/05/2025", 1.89, "Limpeza", "Unidade");
        Produtos item5 = new Produtos(5, "Nescau", "16/05/2024", "16/05/2025", 12.99, "Alimenticio", "Pacote 500g");
        Produtos item6 = new Produtos(6, "Café", "16/05/2024", "16/05/2025", 21.50, "Alimenticio", "Pacote 500g");
        Produtos item7 = new Produtos(7, "Coca cola", "16/05/2024", "16/05/2025", 10.00, "Alimenticio", "Garrafa");

        listaDeProdutos.add(item1);
        listaDeProdutos.add(item2);
        listaDeProdutos.add(item3);
        listaDeProdutos.add(item4);
        listaDeProdutos.add(item5);
        listaDeProdutos.add(item6);
        listaDeProdutos.add(item7);

        String encerrarPrograma = "";
        String encerrarCadastro;
        /*
         Aqui criamos a váriavel novoCodigo e iniciamos ela com 8, porque ela vai ser responsavel por atribuir um codigo
         novo para cada um dos objetos criados a seguir. o ultimo objeto cadastrado foi o item7, que tem o codigo: 7,
         por isso ela começa com 8.
         */
        int novoCodigo = 8;

        /*
            Aqui temos um While, com um menu de opções que é ativado com o 'switch' que vem logo em seguida. quando o usuario
            seleciona a opção 3 - o programa é finalizado.
            ao acessar a opção 1 - é iniciado mais um while, esse sendo para
            cadastro de produtos. o dado de codigo é gerado automaticamente e o programa só solicida - nome - data de fabricação
             - data de validade, preço, categoria e unidade de medida. o usuario escolhe se deseja continuar cadastrando produtos ou não,
              caso deseje parar o programa volta para o primeiro menu de opções.
             ao acessar o menu 2 - o usuario recebe um segundo menu, que pergunta se ele deseja acessar a opção de ver
             todos os produtos, que só mostra codigo, nome e preço, de forma ordenada a partir do código,
             ou se ele deseja ver os dados de apenas 1 produto, mas completos.
             Ao selecionar apenas um produto, o usuario tem as opções de: modificar o nome do produto; excluir o produto; voltar para o menu.
             sempre que o usuario desejar modificar o nome do produto ou exclui-lo, ele é questionado se deseja ou não continuar a operação.
             no final o usuario é redirecionado para o primeiro menu, novamente.
         */
        while(!"sair".equals(encerrarPrograma)) { //enquanto encerrarPrograma for diferente de sair, o laço continuará funcionando.

            System.out.println("\n[1] Para cadastrar um Item"
                             + "\n[2] Para acessar a lista de itens"
                             + "\n[3] para sair");

            int opcaoMenu = sc.nextInt();
            sc.nextLine(); //para limpar

            switch (opcaoMenu) {
                case 1:
                    encerrarCadastro = "";
                    while (!"n".equals(encerrarCadastro)) {
                        int codigo = novoCodigo; //o atributo codigo é incrementado automaticamente

                        //Aqui o programa recebe os dados do(s) produto(s) que o usuario quer criar.
                        System.out.println("Informe o nome: ");
                        String nome = sc.nextLine();

                        System.out.println("Informe a data de fabricação: [00/00/00]");
                        String dataFabricacao = sc.nextLine();

                        System.out.println("Informe a data de validade: [00/00/00]");
                        String dataValidade = sc.nextLine();

                        System.out.println("Informe o preço: [00,00]");
                        double preco = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Informe a categoria: [Alimenticio, limpeza, etc]");
                        String categoria = sc.nextLine();

                        System.out.println("Informe a unidade de medida: [Pacote, unidade, etc]");
                        String unidadeMedida = sc.nextLine();

                        Produtos item = new Produtos(codigo, nome, dataFabricacao, dataValidade, preco, categoria, unidadeMedida); //aqui é aonde o programa cria o novo objeto
                        listaDeProdutos.add(item); // aqui adicionamos o objeto ao ArrayList
                        novoCodigo++; //toda vez que um objeto é criado, a variavel novoCodigo é incrementada

                        System.out.println("Deseja continuar cadastrando itens? [s/n]");
                        encerrarCadastro = sc.nextLine().toLowerCase(); // aqui o usuario pode continuar ou sair do laço
                    }
                    break;
                case 2:
                    System.out.println("\n[1] Para acessar a lista de todos os itens"
                                       +"\n[2] Para acessar apenas um item"
                                       +"\n[3] para voltar para o menu");

                    int opcaoItem = sc.nextInt();
                    sc.nextLine();

                    switch (opcaoItem){
                        case 1:
                            lista(listaDeProdutos); //aqui mostramos a função que foi criada no começo da classe.
                            break;
                        case 2:
                            System.out.println("Informe o codigo do Item: ");
                            int item = sc.nextInt();
                            sc.nextLine();

                            codigoCadastrado = false; //codigoCadastrado sempre começará como falso antes de entrar na validação dos códigos

                            for (int z = 0; z < listaDeProdutos.size(); z++){
                                int s = listaDeProdutos.get(z).getCodigo();
                                if (s == item){
                                    codigoCadastrado = true;
                                    System.out.println(listaDeProdutos.get(z).getTodosAtributos());
                                    //após mostrar todos os atributos, ele inicia um menu para modificar, excluir ou voltar para o menu
                                    System.out.println("\n[1] Para modificar o nome do item"
                                                       +"\n[2] Para excluir o item"
                                                       +"\n[3] para voltar para o menu"  );
                                    int opcao = sc.nextInt();
                                    sc.nextLine();

                                    // Aqui entramos em mais um switch de escolhas para o usuario. se ele deseja modificar, excluir ou apenas voltar para o menu
                                    switch (opcao){
                                        case 1:
                                            System.out.println("Tem certeza que deseja modificar o nome deste item? [s/n]");
                                            String itemModificacao = sc.nextLine().toLowerCase();

                                            if(itemModificacao.equals("s")){
                                                System.out.println("Digite o novo nome: ");
                                                String novoNome = sc.nextLine(); //o novo nome é armazenado em uma variavel temporaria
                                                listaDeProdutos.get(z).setNome(novoNome); //o novoNome substitui o nome anterior deste objeto
                                                System.out.println("Nome modificado");
                                            }else{
                                                System.out.println("Cancelando modificação");
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Tem certeza que deseja remover este item? [s/n]");
                                            String itemRemocao = sc.nextLine().toLowerCase();

                                            if(itemRemocao.equals("s")){
                                                listaDeProdutos.remove(z);
                                                //quando o usuario confirma a remoção do Item, chamamos está função remove(); para remover o objeto da lista
                                                System.out.println("Item removido");
                                            }else{
                                                System.out.println("Cancelando remoção");
                                            }
                                            break;
                                        case 3: break; //Aqui o usuario é direcionado para o primeiro Menu.
                                        default:
                                            System.out.println("Comando invalido. Voltando para o menu");
                                            //ao digitar qualquer numero que não esteja em um dos 3 casos, o programa volta para o menu
                                            break;
                                    }
                                }else{} //caso o usuario não entre no if de codigoCadastrado, ele simplesmente continua o programa com o codigoCadastrado sendo false.
                            }
                        if (codigoCadastrado == false){
                            //caso o codigo digitado pelo usuario não esteja na lista, ele mostra a seguinte mensagem:
                            System.out.println("Codigo não cadastrado");
                            break;
                        }
                            break;
                        case 3:
                            break; // aqui o usuario é redirecionado para o menu
                        default:
                        System.out.println("Comando inválido, voltando para o menu");
                        //caso o usuario digite um comando que não seja uma das opções do programa, ele volta para o menu
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Encerrando o programa");
                    encerrarPrograma = "sair"; //a variavel encerrarPrograma recebe "sair" e o programa é finalizado
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
