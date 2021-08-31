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

data class Measure (
    val imperial: String,
    val metric: String
)

data class Image (
    val id: String,
    val width: Long,
    val height: Long,
    val url: String
)
