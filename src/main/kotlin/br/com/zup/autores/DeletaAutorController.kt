package br.com.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import javax.transaction.Transactional

@Controller("/autores/{id}")
class DeletaAutorController(val repository: AutorRepository) {

    @Delete
    @Transactional
    fun deleta(@PathVariable id: Long) : HttpResponse<Any>{
        val possivelAutor = repository.findById(id)

        if (possivelAutor.isEmpty){
            return HttpResponse.notFound()
        }

        repository.deleteById(id)
        return HttpResponse.ok()
    }
}