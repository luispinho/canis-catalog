package pt.pinho.caniscatalog.data.model

data class DogBreed (
    val weight: Measure,
    val height: Measure,
    val id: Long,
    val name: String,
    val bredFor: String,
    val breedGroup: String,
    val lifeSpan: String,
    val temperament: String,
    val origin: String,
    val referenceImageID: String,
    val image: Image
)
{
    constructor() : this(Measure(), Measure(), -1, "", "", "", "", "", "", "", Image())
}

data class Measure (
    val imperial: String,
    val metric: String
)
{
    constructor(): this("", "")
}

data class Image (
    val id: String,
    val width: Long,
    val height: Long,
    val url: String
)
{
    constructor(): this("", 0, 0, "")
}
