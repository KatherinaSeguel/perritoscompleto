package cl.cristianvidal.dogsmobdevapp.api

import cl.cristianvidal.dogsmobdevapp.breedImagesList.data.BreedImages
import cl.cristianvidal.dogsmobdevapp.breedList.data.Breed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
interface ApiDogService {


    @GET("/api/breeds/list")
    suspend fun getBreedList(): Response<ResultResponseFromAPI<Breed>>


    @GET("/api/breed/{breed name}/images")
    suspend fun getImagesOfSelectedBreed(@Path("breed") breed: String): Response<ResultResponseFromAPI<BreedImages>>

}