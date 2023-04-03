package principal;

import entidades.Autor;
import entidades.Biblioteca;
import entidades.Livro;

public class Principal {
    public static void main(String[] args) {
        Biblioteca lib = new Biblioteca();

        //Autores
        Autor autor1 = new Autor("xxx", "yyy");
        Autor autor2 = new Autor("www", "aaa");
        Autor autor3 = new Autor("qqq", "bbb");

        //Livros
        Livro livro1 = new Livro("Linguagem C", "11 de junho de 2001", 230);
        Livro livro2 = new Livro("Redes de computadores", "22 de abril de 2005", 120);
        Livro livro3 = new Livro("Física II", "15 de julho de 2003", 678);

        //Add autores nos respectivos livros
        livro1.adicionarAutor(autor3);
        livro2.adicionarAutor(autor2);
        livro3.adicionarAutor(autor1);
        
        //Add livro na biblioteca
        lib.inserirItem(livro1);
        lib.inserirItem(livro2);
        lib.inserirItem(livro3);

        //Listar itens
        lib.listarItens();
    }
}
