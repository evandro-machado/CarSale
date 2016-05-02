package com.example.evandro.carsale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evandro on 5/1/2016.
 */
public class Carro {
    private int idImagem;
    private String modelo;
    private String fabricante;
    private String cor;
    private double preco;

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<Carro> gerarLista(){
        List<Carro> listaCarros = new ArrayList<>();

        Carro carro = new Carro();
        carro.setIdImagem(0);
        carro.setModelo("Gol");
        carro.setCor("Preto");
        carro.setFabricante("Wolksvagen");
        carro.setPreco(35432.67);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(1);
        carro.setModelo("Uno");
        carro.setCor("Prata");
        carro.setFabricante("Fiat");
        carro.setPreco(31765.32);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(2);
        carro.setModelo("Palio");
        carro.setCor("Azul");
        carro.setFabricante("Fiat");
        carro.setPreco(25056.55);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(3);
        carro.setModelo("Fox BlueMotion");
        carro.setCor("Vermelho");
        carro.setFabricante("Wolksvagen");
        carro.setPreco(46987.89);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(4);
        carro.setModelo("Siena EL");
        carro.setCor("Branco");
        carro.setFabricante("Fiat");
        carro.setPreco(37767.87);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(5);
        carro.setModelo("Celta");
        carro.setCor("Vermelho");
        carro.setFabricante("Chevrolet");
        carro.setPreco(29877.65);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(6);
        carro.setModelo("Voyage");
        carro.setCor("Prata");
        carro.setFabricante("Wolkswagen");
        carro.setPreco(45899.55);

        listaCarros.add(carro);
        carro = new Carro();
        carro.setIdImagem(7);
        carro.setModelo("HB20");
        carro.setCor("Preto");
        carro.setFabricante("Hyundai");
        carro.setPreco(33789.99);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(8);
        carro.setModelo("Onix");
        carro.setCor("Prata");
        carro.setFabricante("Chevrolet");
        carro.setPreco(39898.77);

        listaCarros.add(carro);

        carro = new Carro();
        carro.setIdImagem(9);
        carro.setModelo("320i");
        carro.setCor("Branca");
        carro.setFabricante("BMW");
        carro.setPreco(120766.78);

        listaCarros.add(carro);

        return listaCarros;
    }

    public void toArray(){
        List<Carro> listaCarro = gerarLista();
        List<String> modeloArr = new ArrayList<>();
        List<String> corArr = new ArrayList<>();
        List<String> fabrArr = new ArrayList<>();
        List<Double> precoArr = new ArrayList<>();

        for(Carro car : listaCarro){
            modeloArr.add(car.getModelo());
            corArr.add(car.getCor());
            fabrArr.add(car.getFabricante());
            precoArr.add(car.getPreco());
        }
        System.out.println(modeloArr.toString());
        System.out.println(corArr.toString());
        System.out.println(fabrArr.toString());
        System.out.println(precoArr.toString());


    }
}
