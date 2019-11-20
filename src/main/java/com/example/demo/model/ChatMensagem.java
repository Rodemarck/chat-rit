package com.example.demo.model;

public class ChatMensagem {
    private String conteudo;

    @Override
    public String toString() {
        return "ChatMensagem{" +
                "conteudo='" + conteudo + '\'' +
                ", remetente='" + remetente + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    private String remetente;
    private TipoMensagem tipo;

    public TipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    public enum TipoMensagem{
        CHAT,SAIDA,ENTRADA
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
}
