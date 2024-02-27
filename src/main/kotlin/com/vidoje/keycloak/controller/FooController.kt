package com.vidoje.keycloak.controller

import com.vidoje.keycloak.model.Foo
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/foo")
class FooController {

    @GetMapping("/1")
    @PreAuthorize("hasAuthority('SCOPE_forbidden')")
    fun findAll1(@PathVariable id: Long?): List<Foo> {
        return listOf(Foo(1, "Foo1"), Foo(2, "Foo2"), Foo(3, "Foo3"))
    }

    @GetMapping("/2")
    @PreAuthorize("hasAuthority('SCOPE_phone')")
    fun findAll2(@PathVariable id: Long?): List<Foo> {
        return listOf(Foo(1, "Foo1"), Foo(2, "Foo2"), Foo(3, "Foo3"))
    }

    @GetMapping("/3")
    @PreAuthorize("permitAll()")
    fun findOne3(@PathVariable id: Long?): List<Foo> {
        return listOf(Foo(1, "Foo1"), Foo(2, "Foo2"), Foo(3, "Foo3"))
    }

}