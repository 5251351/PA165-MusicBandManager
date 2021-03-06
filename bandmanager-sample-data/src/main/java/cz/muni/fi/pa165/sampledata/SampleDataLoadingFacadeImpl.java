package cz.muni.fi.pa165.sampledata;

import cz.muni.fi.pa165.entity.*;
import cz.muni.fi.pa165.enums.Genre;
import cz.muni.fi.pa165.enums.Role;
import cz.muni.fi.pa165.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

/**
 * @author Iurii xkuznetc Kuznetcov, Miroslav Kadlec
 */

@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

    @Autowired
    ManagerService managerService;

    @Autowired
    MemberService memberService;

    @Autowired
    BandService bandService;

    @Autowired
    SongService songService;

    @Autowired
    AlbumService albumService;

    @Autowired
    TourService tourService;

    @Autowired
    BandInviteService bandInviteService;

    @Override
    public void loadData() throws IOException {
        Manager williams = this.manager("Allan Williams", "willy@tiscali.com", "iloveringo");
        Manager oldham = this.manager("Andrew Oldham", "a_oldham@rollingstones.com", "IWanaBeYourMan");
        Manager chen = this.manager("Lennie Chen", "chen@bigboss.com", "lenieChenPass");

        Band beatles = this.band("Beatles", williams, Genre.ROCK, "https://cps-static.rovicorp.com/3/JPG_400/MI0003/995/MI0003995354.jpg?partner=allrovi.com");
        Band wailers = this.band("The Wailers", chen, Genre.REGGAE, "https://img.discogs.com/3_C_hNpOQszGzu8bxNHpl91RAgI=/fit-in/300x300/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-21764-1444051758-7211.jpeg.jpg");
        Band stones = this.band("Rolling stones", oldham, Genre.ROCK, "http://e-cdn-images.deezer.com/images/artist/2ceac184bc846327f60c5b0d4247cc7a/200x200-000000-80-0-0.jpg");
        Band smallFaces = this.band("Small Faces", oldham, Genre.ROCK, "https://upload.wikimedia.org/wikipedia/commons/0/0b/Small_Faces_1965.JPG");

        Member lennon = this.member("John Lennon", "john@beatles.com", beatles, Role.KEYS, "1234Lennon");
        Member mccartney = this.member("Paul McCartney", "paul@beatles.com", beatles, Role.BASSIST, "McCartney4321");
        Member harrison = this.member("George Harrison", "george@beatles.com", beatles, Role.GUITARIST, "xxHarrisonxx");
        Member starr = this.member("Ringo Starr", "ringo@beatles.com", null, Role.DRUMMER, "1324Starr");

        Member jagger = this.member("Mick Jagger", "jagger@rs.com", stones, Role.VOCALS, "MickJagger1234");
        Member richards = this.member("Keith Richards", "richards@rs.com", null, Role.GUITARIST, "KeithXXXX");
        Member wood = this.member("Ron Wood", "wood@rs.com", stones, Role.GUITARIST, "KeithXXXX");
        Member watts = this.member("Charlie Watts", "watts@rs.com", stones, Role.DRUMMER, "KeithXXXX");

        Member marley = this.member("Bob Marley", "bobmarley@reggae.com", wailers, Role.VOCALS, "bobPassword");
        Member livingston = this.member("Bunny Livingston", "bunnylivingston@reggae.com", wailers, Role.DRUMMER, "1234livingston");
        Member tosh = this.member("Peter Tosh", "petertosh@reggae.com", wailers, Role.GUITARIST, "**tosh**");

        Member mariott = this.member("Steve Mariott", "mariott@faces.org", smallFaces, Role.GUITARIST, "mariXXott");
        Member jones = this.member("Kenney Jones", "jones@faces.org", smallFaces, Role.DRUMMER, "1234_jones");
        Member lane = this.member("Ronnie Lane", "ronnielane@faces.org", smallFaces, Role.BASSIST, "ronnie1234lane");
        Member winston = this.member("Jimmy Winston", "winston@faces.org", null, Role.KEYS, "jimmiWin");

        Member cash = this.member("Johny Cash", "johny_cash@gmail.com", null, Role.GUITARIST, "1234cash-pass");

        Song ogdens = this.song("Ogdens Nut Gone Flake", smallFaces, Long.valueOf(146));
        Song afterglow = this.song("Afterglow of Your Love", smallFaces, Long.valueOf(211));
        Song shake = this.song("Shake", smallFaces, Long.valueOf(146));

        Song sheSaidYeah = this.song("She Said Yeah", stones, Long.valueOf(94));
        Song mercyMercy = this.song("Mercy mercy", stones, Long.valueOf(165));
        Song sympathyForTheDevil = this.song("Sympathy for the devil", stones, Long.valueOf(378));
        Song satisfaction = this.song("Satisfaction", stones, Long.valueOf(224));


        Song solution = this.song("Solution", wailers, Long.valueOf(388));
        Song reggaeLove = this.song("Reggae love", wailers, Long.valueOf(249));
        Song goToHeaven = this.song("Everybody Wants to Go to Heaven", wailers, Long.valueOf(333));

        Song myBonnie = this.song("M Bonnie", beatles, Long.valueOf(197));
        Song sheLovesYou = this.song("She loves you", beatles, Long.valueOf(138));

        Album smallFacesAlbum = this.album("Small Faces", smallFaces, "https://upload.wikimedia.org/wikipedia/en/d/d4/Smallfaces1960.jpg", shake);
        Album ogdensAlbum = this.album("ogdensAlbum", smallFaces, "https://upload.wikimedia.org/wikipedia/en/thumb/1/1d/Small_Faces_-_Ogdens%27_Nut_Gone_Flake.png/220px-Small_Faces_-_Ogdens%27_Nut_Gone_Flake.png", ogdens, afterglow);
        Album outOfOurHeadAlbum = this.album("Out of Our Heads", stones, "https://upload.wikimedia.org/wikipedia/en/b/bd/Out%2Bof%2BOur%2BHeads%2B-UK-.jpg", sheSaidYeah, mercyMercy);
        Album beggarsBanquetAlbum = this.album("Beggars Banquet", stones, "https://upload.wikimedia.org/wikipedia/commons/8/8b/BeggarsBanquetLP.jpg", sympathyForTheDevil);
        Album iDAlbum = this.album("I. D,", smallFaces, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Small_Faces_1965.JPG/220px-Small_Faces_1965.JPG", solution, reggaeLove);

        Tour stonesUSA = this.tour("Stones in USA", oldham, stones, "New York", new Date(1513363723));
        Tour stonesRussia = this.tour("Stones in Russia", oldham, stones, "Moscow", new Date(1813978723));
        Tour wailersToronto = this.tour("Reggae festival", chen, wailers, "Toronto", new Date(1999978723));
        Tour smallFacesLondon = this.tour("Rolling Stones Megaconcert", oldham, smallFaces, "London", new Date(1893988733));

        BandInvite richardsInv = this.bandInvite(oldham, stones, richards, new Date(223988833));
        BandInvite winstonInv = this.bandInvite(oldham, smallFaces, winston, new Date(225682873));
        BandInvite ringo = this.bandInvite(williams, beatles, starr, new Date(111682873));
    }

    private BandInvite bandInvite(Manager manager, Band band, Member member, Date createdAt) {
        BandInvite bandInvite = new BandInvite();
        bandInvite.setManager(manager);
        bandInvite.setBand(band);
        bandInvite.setInvitedMember(member);
        bandInvite.setCreatedAt(createdAt);
        bandInvite = this.bandInviteService.create(bandInvite);
        managerService.addBandInvite(manager, bandInvite);
        memberService.sendBandInvite(member, bandInvite);
        return bandInvite;
    }

    private Tour tour(String name, Manager manager, Band band, String cityName, Date datetime) {
        Tour tour = new Tour();
        tour.setName(name);
        tour.setManager(manager);
        tour.setBand(band);
        tour.setCityName(cityName);
        tour.setDatetime(datetime);
        tour = tourService.create(tour);
        managerService.addTour(manager, tour);
        bandService.addTour(band, tour);
        return tour;
    }

    private Album album(String name, Band band, String coverURI, Song... songs) {
        Album album = new Album();
        album.setName(name);
        album.setBand(band);
        album.setCoverURI(coverURI);
        for (Song s : songs) {
            album.addSong(s);
        }
        return this.albumService.findById(this.albumService.create(album).getId());
    }

    private Song song(String name, Band band, Long duration) {
        Song song = new Song();
        song.setName(name);
        song.setBand(band);
        song.setDuration(duration);
        return this.songService.findById(this.songService.create(song).getId());
    }

    private Band band(String name, Manager manager, Genre genre, String logoUri) {
        Band band = new Band();
        band.setName(name);
        band.setManager(manager);
        band.setGenre(genre);
        band.setLogoURI(logoUri);
        band = bandService.create(band);
        if (band.getManager() == null) {
            managerService.addManagedBand(manager, band);
        }
        return band;
    }

    private Member member(String name, String email, Band band, Role role, String password) {
        Member mem = new Member();
        mem.setName(name);
        mem.setEmail(email);
        mem.setBand(band);
        mem.setRole(role);
        mem = this.memberService.registerMember(mem, password);
        if (band != null) {
            bandService.addMember(band, mem);
        }
        return mem;
    }

    private Manager manager(String name, String email, String password) {
        Manager mng = new Manager();
        mng.setName(name);
        mng.setEmail(email);
        return this.managerService.findManagerById(this.managerService.registerManager(mng, password).getId());
    }
}
