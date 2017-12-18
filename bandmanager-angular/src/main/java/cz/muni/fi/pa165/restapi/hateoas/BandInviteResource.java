package cz.muni.fi.pa165.restapi.hateoas;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.fi.muni.pa165.dto.BandDTO;
import cz.fi.muni.pa165.dto.BandInviteDTO;
import cz.fi.muni.pa165.dto.ManagerDTO;
import cz.fi.muni.pa165.dto.MemberDTO;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

/**
 * @author Iurii xkuznetc Kuznetcov
 */

@Relation(value = "invite", collectionRelation = "invites")
public class BandInviteResource extends ResourceSupport {

    @JsonProperty("id")
    private long dtoId;
    private BandDTO band;
    private MemberDTO member;
    private ManagerDTO manager;

    public BandInviteResource(BandInviteDTO bandInviteDTO) {
        this.dtoId = bandInviteDTO.getId();
        this.band = bandInviteDTO.getBand();
        this.member = bandInviteDTO.getMember();
        this.manager = bandInviteDTO.getManager();
    }

    public long getDtoId() {
        return dtoId;
    }

    public void setDtoId(long dtoId) {
        this.dtoId = dtoId;
    }

    public BandDTO getBand() {
        return band;
    }

    public void setBand(BandDTO band) {
        this.band = band;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public ManagerDTO getManager() {
        return manager;
    }

    public void setManager(ManagerDTO manager) {
        this.manager = manager;
    }
}
