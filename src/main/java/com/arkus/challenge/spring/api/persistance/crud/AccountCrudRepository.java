package com.arkus.challenge.spring.api.persistance.crud;

import com.arkus.challenge.spring.api.persistance.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountCrudRepository extends CrudRepository<Account, Integer> {
    @Query(value = "SELECT cuentas.*, users.nombre AS responsable FROM cuentas INNER JOIN cuentas_users ON cuentas.id = cuentas_users.cuenta_id INNER JOIN users ON cuentas_users.user_id = users.id WHERE cuentas_users.responsable = 1", nativeQuery = true)
    List<Account> getAllAccounts();

    @Query(value = "SELECT cuentas.*, users.nombre AS responsable FROM cuentas INNER JOIN cuentas_users ON cuentas.id = cuentas_users.cuenta_id INNER JOIN users ON cuentas_users.user_id = users.id WHERE cuentas_users.responsable = 1 AND cuentas.id = ?", nativeQuery = true)
    Optional<Account> findById(int id);
}
