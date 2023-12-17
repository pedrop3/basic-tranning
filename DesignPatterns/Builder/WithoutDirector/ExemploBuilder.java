package DesignPatterns.Builder.WithoutDirector;

public class ExemploBuilder {

    public static void main(String[] args) {

        Car car = new Car.Builder("Fox", "Bonito").build();
        System.out.println(
                "Nome:" + car.getNome() + "- Descrição: " + car.getDescricao() + " - Preço: " + car.getPreco());

    }

    static class Car {

        private String nome;
        private String descricao;
        private double preco;

        public Car(Builder builder) {
            this.nome = builder.nome;
            this.descricao = builder.descricao;
            this.preco = builder.preco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        static class Builder {
            private String nome;
            private String descricao;
            private double preco;

            public Builder(String nome, String descricao, double preco) {
                this.nome = nome;
                this.descricao = descricao;
                this.preco = preco;
            }

            public Builder(String nome, String descricao) {
                this.nome = nome;
                this.descricao = descricao;
            }

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public String getDescricao() {
                return descricao;
            }

            public void setDescricao(String descricao) {
                this.descricao = descricao;
            }

            public double getPreco() {
                return preco;
            }

            public void setPreco(double preco) {
                this.preco = preco;
            }

            Car build() {
                return new Car(this);
            }

        }

    }

}
