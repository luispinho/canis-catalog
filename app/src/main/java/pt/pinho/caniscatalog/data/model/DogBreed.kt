package pt.pinho.caniscatalog.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dog_breed")
data class DogBreed (
    @Embedded(prefix = "weight_")
    val weight: Measure,
    @Embedded(prefix = "height_")
    val height: Measure,
    @PrimaryKey
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
    @Embedded
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
    @ColumnInfo(name = "image_id")
    val id: String,
    val width: Long,
    val height: Long,
    val url: String
)
{
    constructor(): this("", 0, 0, "")
}
