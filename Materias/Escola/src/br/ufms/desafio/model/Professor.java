/*
 * Copyright (C) 2016 Higor
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

import java.util.List;

/**
 * @author Higor
 */
public class Professor extends Jogador{

    private Titulacao titulacao;
    private List<Escola> escola;
    private List<Turma> turma;

    public List<Escola> getEscola() {
        return escola;
    }

    public Professor setEscola(List<Escola> escola) {
        this.escola = escola;
        return this;
    }

    public Titulacao getTitulacao() {
        return titulacao;
    }

    public Professor setTitulacao(Titulacao titulacao) {
        this.titulacao = titulacao;
        return this;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public Professor setTurma(List<Turma> turma) {
        this.turma = turma;
        return this;
    }
}
