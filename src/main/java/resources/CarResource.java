package resources;

import services.CarService;
import control.Specification;
import entities.Car;
import enums.EngineType;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

@Path("cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    @Inject
    CarService carManufacturer;

    @Context
    UriInfo uriInfo;

//    @Inject
//    Validator validator;


    @GET
//    public List<Car> findAll() {
    public JsonArray findAll(@QueryParam("filter") EngineType engineType) {
        return carManufacturer.findAll()
                .stream()
                .map(car -> Json.createObjectBuilder()
                    .add("color", car.getColor().name())
                    .add("engine", car.getEngineType().name())
                    .add("id", car.getId())
                    .build())
                .collect(JsonCollectors.toJsonArray());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(@Valid @NotNull Specification specification){
        Car car = carManufacturer.manufactoreCar(specification);
        URI uri = uriInfo.getBaseUriBuilder()
                .path(CarResource.class)
                .path(CarResource.class, "findById")
                .build(car.getId());
        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Car findById(@PathParam("id") String id) {
        return carManufacturer.findById(id);
    }

}
