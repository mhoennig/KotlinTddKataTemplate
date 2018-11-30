package de.javagil.kata

class Testee(val delegate: Delegate = Delegate()) {

    fun quote(text: String) = delegate.inner(text)

}

open class Delegate {
    fun inner(text: String) = "'$text'"
}
