package com.apside.prono.errors;

public class PlayerInconnuException extends PronoException {

	public PlayerInconnuException(long id) {
		
		super("Le Player avec l'ID " + id + " n'existe pas !");
	}
}
