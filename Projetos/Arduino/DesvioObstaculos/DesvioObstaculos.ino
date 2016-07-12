/*
   Created by Kleber Kruger on 01/07/2016.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

#include <StateMachine.h>
#include <Ultrasonic.h>

typedef enum {

  // Pinos do motor esquerdo
  MOTOR_ESQ_ENABLE = 10,
  MOTOR_ESQ_P1 = 2,
  MOTOR_ESQ_P2 = 9,

  // Pinos do motor direito
  MOTOR_DIR_ENABLE = 5,
  MOTOR_DIR_P1 = 7,
  MOTOR_DIR_P2 = 8,

  // Pinos dos sensores ultrasônicos
  ULTRASONICO_ESQ_TRIGGER = 13,
  ULTRASONICO_ESQ_ECHO = 6,
  ULTRASONICO_DIR_TRIGGER = 13,
  ULTRASONICO_DIR_ECHO = 11,
  ULTRASONICO_CABECA_TRIGGER = 4,
  ULTRASONICO_CABECA_ECHO = 12

} PinName;

// Velocidade
const int VELOCIDADE = 128;

// Distância mínima para o objeto
const float DISTANCIA_MINIMA = 10;

typedef enum {
  LIVRE = 0,
  OBJETO_A_ESQUERDA = 1,
  OBJETO_A_DIREITA = 2,
  OBJETO_NA_FRENTE = 3 // (OBJETO_A_ESQUERDA + OBJETO_A_DIREITA)
} Situacao;

class MovimentoCarro;
class MovimentoCabeca;
class Decidir;
class AndarPraFrente;
class DesviarPelaDireita;
class DesviarPelaEsquerda;
class AlterarRumo;

class Decidir : public State {
  public:

    Decidir() :
      usEsq(ULTRASONICO_ESQ_TRIGGER, ULTRASONICO_ESQ_ECHO),
      usDir(ULTRASONICO_DIR_TRIGGER, ULTRASONICO_ESQ_ECHO) { }

    Decidir(Decidir &orig) : usEsq(orig.usEsq), usDir(orig.usDir) { }

    ~Decidir() { }

    void run(StateMachine &sm) {

      switch (algoAFrente()) {

        case LIVRE:
              digitalWrite(MOTOR_ESQ_P1, HIGH);
      digitalWrite(MOTOR_ESQ_P2, LOW);
      digitalWrite(MOTOR_DIR_P1, LOW);
      digitalWrite(MOTOR_DIR_P2, HIGH);

//          sm.setToState<AndarPraFrente>();
          break;
        case OBJETO_A_ESQUERDA:
          sm.setToState<DesviarPelaDireita>();
          break;
        case OBJETO_A_DIREITA:
          sm.setToState<DesviarPelaEsquerda>();
          break;
        case OBJETO_NA_FRENTE:
          sm.setToState<AlterarRumo>();
          break;
      }
    }

  private:

    Ultrasonic usEsq;
    Ultrasonic usDir;

    Situacao algoAFrente() {

      float cmEsq = usEsq.convert(usEsq.timing(), Ultrasonic::CM);
      float cmDir = usDir.convert(usDir.timing(), Ultrasonic::CM);
      int s = LIVRE;

      if (cmEsq < DISTANCIA_MINIMA) s += OBJETO_A_ESQUERDA;
      if (cmDir < DISTANCIA_MINIMA) s += OBJETO_A_DIREITA;
      
      return (Situacao) s;
    }
};

class MovimentoCarro {
//  protected:
//
//    void andarPraFrente() {
//      moverRodaEsqueda(HIGH);
//      moverRodaDireita(HIGH);
//    }
//
//    void virarAEsquerda() {
//      moverRodaEsqueda(LOW);
//      moverRodaDireita(HIGH);
//    }
//
//    void virarADireita() {
//      moverRodaEsqueda(HIGH);
//      moverRodaDireita(LOW);
//    }
//
//    void parar() {
//      digitalWrite(MOTOR_ESQ_P1, LOW);
//      digitalWrite(MOTOR_ESQ_P2, LOW);
//      digitalWrite(MOTOR_DIR_P1, LOW);
//      digitalWrite(MOTOR_DIR_P2, LOW);
//    }
//
//  private:
//
//    inline void moverRodaEsqueda(bool sentido) {
//      digitalWrite(MOTOR_ESQ_P1, sentido);
//      digitalWrite(MOTOR_ESQ_P2, !sentido);
//    }
//
//    inline void moverRodaDireita(bool sentido) {
//      digitalWrite(MOTOR_DIR_P1, sentido);
//      digitalWrite(MOTOR_DIR_P2, !sentido);
//    }
//};

class MovimentoCabeca {
  private:

    Ultrasonic usCabeca;

  protected:

    MovimentoCabeca() : usCabeca(ULTRASONICO_CABECA_TRIGGER, ULTRASONICO_CABECA_ECHO) { };

    void girarAEsquerda() { }

    void girarADireita() { }

    Situacao getSituacao() {
      float cm = usCabeca.convert(usCabeca.timing(), Ultrasonic::CM);
      return (cm < DISTANCIA_MINIMA) ? LIVRE : OBJETO_NA_FRENTE;
    }
};

class AndarPraFrente : public State, public MovimentoCarro {

    void run(StateMachine & sm) {
      andarPraFrente();
    }
};

class DesviarPelaEsquerda : public State, public MovimentoCarro, public MovimentoCabeca {

    void run(StateMachine &sm) {

    }
};

class DesviarPelaDireita : public State, public MovimentoCarro, public MovimentoCabeca {

    void run(StateMachine &sm) {

    }
};

class AlterarRumo : public State, public MovimentoCarro, public MovimentoCabeca {

    void run(StateMachine &sm) {
      
      delay(2000);
      parar();
    }
};

void setup() {
  Serial.begin(9600);

  pinMode(MOTOR_ESQ_P1, OUTPUT);
  pinMode(MOTOR_ESQ_P2, OUTPUT);
  pinMode(MOTOR_DIR_P1, OUTPUT);
  pinMode(MOTOR_DIR_P2, OUTPUT);

  analogWrite(MOTOR_ESQ_ENABLE, VELOCIDADE);
  analogWrite(MOTOR_DIR_ENABLE, VELOCIDADE + 8);

  StateMachine sm;
  sm.start<Decidir>();
}

void loop() { }
