#Author: michelerichter@e2etreinamentos.com.br

@todos
Feature: Realizar busca de cep ou endereco
  Eu como usuario quero realizar busca de cep ou endere�o para obter iformacoes

Background: Buscar cep ou endereco
Given que esteja no site do correios

  @positivo
  Scenario: Buscar cep valido
   When informar cep valido
   Then sistema apresenta informacoes
   
  @negativo
  Scenario: Buscar cep inexistente
   But informar cep inexistente
   When realizar busca
   Then sistema nao encontra informacoes