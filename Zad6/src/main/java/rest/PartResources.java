package rest;

import domain.ComputerParts;
import domain.GraphicsCard;
import domain.services.PartService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/shop")
@Stateless
public class PartResources {

    private PartService db = new PartService();

    @PersistenceContext
    EntityManager em;

    @GET
    @Path("/GPU")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GraphicsCard> getAllGPU() {
        return em.createNamedQuery("graphicsCard.all", GraphicsCard.class).getResultList();
    }

    @GET
    @Path("/GPU/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGpu(@PathParam("id") int id){
        GraphicsCard result = em.createNamedQuery("graphicsCard.id", GraphicsCard.class)
                .setParameter("gpuId", id)
                .getSingleResult();
        if(result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @POST
    @Path("/GPU")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGpu(GraphicsCard graphicsCard) {
        em.persist(graphicsCard);
        return Response.ok(graphicsCard.getId()).build();
    }

    @PUT
    @Path("/GPU/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editGpu(@PathParam("id") int id, GraphicsCard gpu) {
        GraphicsCard result = em.createNamedQuery("graphicsCard.id", GraphicsCard.class)
                .setParameter("gpuId", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        result.setModel(gpu.getModel());
        result.setPrice(gpu.getPrice());
        em.persist(result);
        return Response.ok().build();
    }

    @GET
    @Path("/GPU/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getModelGpu(@PathParam("model") String model, GraphicsCard gpu) {
        GraphicsCard result = em.createNamedQuery("graphicsCard.model", GraphicsCard.class)
                .setParameter("gpuModel", model)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ComputerParts> getAll() {
        return em.createNamedQuery("computerParts.all", ComputerParts.class).getResultList();
    }


}
