package com.poe.javatos.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poe.javatos.bean.Client;

public interface IClientRepositoryCrud extends JpaRepository<Client, Integer> {

}
