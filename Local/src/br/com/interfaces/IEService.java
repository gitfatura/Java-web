package br.com.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IEService<T> {

	default void save(HttpServletRequest request, HttpServletResponse response)throws Exception {

	}

	default void update(HttpServletRequest request, HttpServletResponse response)throws Exception {

	}

	default void remove(HttpServletRequest request, HttpServletResponse response)throws Exception {

	}

	default void getId(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}

	default void getProduto(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}

	default void getAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}

}
