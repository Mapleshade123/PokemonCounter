package main

import requests.{Response, check}
import io.github.juliano.pokeapi.requests.PokemonRequest
import io.github.juliano.pokeapi.PokeApiClient
import sttp.client3.{HttpClientSyncBackend, Identity, SttpBackend}
import io.github.juliano.pokeapi.requests.MoveRequest
import sttp.client3.{SttpBackend, TryHttpURLConnectionBackend}
import scala.io.StdIn.readLine

import scala.annotation.tailrec
import scala.util.*

given backend: SttpBackend[Try, Any] = TryHttpURLConnectionBackend()
val client = PokeApiClient()

def checkPokemon(x : Int) : Option[String] = client.send(PokemonRequest(x)) match {
  case Success(pokemon) => Some(pokemon.name)
  case Failure(t) => None
}

def showPokemon (x : Int) : Unit = checkPokemon(x) match {
  case Some(p) => println(s"$x $p")
  case None => None
}

@tailrec
def printPokemons(x : Int, y : Int) : Unit = {
  showPokemon(x)
  if (x < y) printPokemons(x + 1, y)
}

object get extends App{
//  val r: Response = requests.get("https://pokeapi.co/api/v2/pokemon/35/")
//  val responseText = r.text()
//  print(r.text())
  println("Введите диапазон покемонов")
  val x = readLine().toInt
  val y = readLine().toInt
  printPokemons(x, y)
}
