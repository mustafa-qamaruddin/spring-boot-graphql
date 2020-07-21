```
http://localhost:8080/graphql
```

```
{
  bookById(id: "book-2") {
    id
    name
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

<img src="images/1.png" align=center" />