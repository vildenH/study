package main

import (
	"fmt"
)

type Person struct {
	name string
	sex  bool
}

func main() {
	fmt.Println("hello world")
	var a string = "hello world"
	fmt.Println(a)

	var count int = 1
	var pointer2 *int
	pointer2 = &count
	*pointer2 = 3
	fmt.Println(count)
	fmt.Println(*pointer2)

	var person Person
	person.name = "hao"
	person.sex = true

	fmt.Println(person)

	person2 := Person{
		name: "hao",
		sex:  false,
	}
	fmt.Println(person2)

	test(&person2)
	fmt.Println(person2)

	s := []int{1, 2, 3}
	fmt.Println(s)
	s = append(s, 1)
	fmt.Println(s)

	for i, value := range s {
		fmt.Println(i, value)

	}
	for i, value := range s[1:] {
		fmt.Println(i, value)
	}

}

func test(person *Person) {
	person.name = "123"

	fmt.Println(person)
}
