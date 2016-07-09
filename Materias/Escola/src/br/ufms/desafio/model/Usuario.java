/*
 * Copyright (C) 2016 kleberkruger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.desafio.model;

import java.time.LocalDate;
import java.util.List;

public class Usuario {

    protected Long idUsuario;
    protected String nome;
    protected String usuario;
    protected String senha;
    protected LocalDate cricao;
    protected String email;
    protected List<Telefone> telefone;
    protected Endereco endereco;

    public Long getCodigo() {
        return codigo;
    }

    public Usuario setCodigo(Long codigo) {
        this.codigo = codigo;
        return this;
    }

    public LocalDate getCricao() {
        return cricao;
    }

    public Usuario setCricao(LocalDate cricao) {
        this.cricao = cricao;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Usuario setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public Usuario setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }
}
