package br.com.fiap.mapeando.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Teste.java -> Compilar -> Teste.class (bytecode) -> Interpretar (JVM) -> Execução

// SOURCE -> até o código, quando compilar não teremos mais o bytecode
// CLASS -> até a compilação (padrão)
// RUNTIME -> até a execução
@Retention(RetentionPolicy.RUNTIME)

// Define onde a anotação pode ser utilizada
// FIELD -> atributos
// METHOD -> Métodos
// ...
@Target({ ElementType.FIELD, ElementType.METHOD })

public @interface Coluna {

	String nome(); // parâmetro da anotação
	int tamanho() default 255;
	boolean unico() default false;
	
}

