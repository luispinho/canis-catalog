package pt.pinho.caniscatalog.data.model

import com.google.gson.annotations.SerializedName

data class DogBreed (
    val weight: Measure,
    val height: Measure,
    val id: Long,
    val name: String,
    @SerializedName("breed_for")
    val bredFor: String,
    @SerializedName("breed_group")
    val breedGroup: String,
    @SerializedName("life_span")
    val lifeSpan: String,
    val temperament: String,
    val origin: String,
    @SerializedName("reference_image_id")
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
