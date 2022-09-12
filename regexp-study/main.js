



const str = `
010-1234-5678
spammy7147@gmail.com
https:www.omdbapi.com/?apikey=7035c60c&s=frozen
The quick brown  fox jumps over the lazy dog.
abbcccdddd
http://localhost:123
동해물과 백두산이 마르고 닳도록
`

const h = `  the hello  world       !

`
console.log(
    str.match(/(?<=@).{1,}/g)
    )
