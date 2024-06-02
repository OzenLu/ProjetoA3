
package com.mycompany.projetoA3;

/**
 *
 *
 */
public class Produtos extends Mercadoria{
    private int codigo;
    private String dataValidade, dataFabricacao;
    private String categoria;
    private String unidadeMedida;

    public Produtos(int codigo, String nome,String dataFabricacao, String dataValidade, double preco, String categoria, String unidadeMedida ){
        super(nome, preco); //Aqui o Construtor passa os parametros 'nome' e 'preco' para a classe pai - Mercadoria.
        this.codigo = codigo;
        this.dataFabricacao = dataFabricacao;
        this.dataValidade = dataValidade;
        this.categoria = categoria;
        this.unidadeMedida = unidadeMedida;
    }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /*
            Override de uma função que já existe. essa função faz parte do .get() na nossa ArrayList, se não tivessemos
            esse Override aqui, a função apenas retornaria o endereço de memoria na qual esses objetos estão armazenados.
            com o Override é possivel subscrever essa função e colocarmos para que ela mostre os dados desejados, no caso são
            o codigo, o nome e o preço.
         */
    @Override
    public String toString(){
        return "   " + getCodigo() + "    " + getNome() + "    " + getPreco();
    }

    /*
        Essa função é semelhante a função de cima, mas ela devolve os dados mais detalhados. Para ela ser chamada, é necessario
        chamar a partir de um objeto, como utilizamos ela junto com a ArrayList, ela normalmente fica assim:
         listaDeProdutos.get(index).getTodosAtributos();
     */
    public String getTodosAtributos(){
        return "\nCodigo: " + getCodigo() +
                "\nNome: " + getNome() +
                "\nData de Fabricação: " + dataFabricacao +
                "\nData de Validade: " + dataValidade +
                "\nCategoria: " + categoria +
                "\nUnidade de medida: " + unidadeMedida +
               "\nPreço: R$" + getPreco();
    }
}
