// package changhong.com.entity;
//
// import javax.persistence.Entity;
// import javax.persistence.Table;
//
// @Entity
// @Table(name = "pets")
// public class Pet {
//
//// @Column(name = "birth_date")
//// @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
//// @DateTimeFormat(pattern = "yyyy/MM/dd")
// private LocalDate birthDate;
//
//// @ManyToOne
//// @JoinColumn(name = "type_id")
//// private PetType type;
//
//// @ManyToOne
//// @JoinColumn(name = "owner_id")
//// private Owner owner;
//
// @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch =
/// FetchType.EAGER)
// private Set<Visit> visits;
//
// public LocalDate getBirthDate() {
// return this.birthDate;
// }
//
// public void setBirthDate(LocalDate birthDate) {
// this.birthDate = birthDate;
// }
//
// public PetType getType() {
// return this.type;
// }
//
// public void setType(PetType type) {
// this.type = type;
// }
//
// public Owner getOwner() {
// return this.owner;
// }
//
// protected void setOwner(Owner owner) {
// this.owner = owner;
// }
//
// protected Set<Visit> getVisitsInternal() {
// if (this.visits == null) {
// this.visits = new HashSet<>();
// }
// return this.visits;
// }
//
// protected void setVisitsInternal(Set<Visit> visits) {
// this.visits = visits;
// }
//
// public List<Visit> getVisits() {
// List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
// PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date",
/// false, false));
// return Collections.unmodifiableList(sortedVisits);
// }
//
// public void addVisit(Visit visit) {
// getVisitsInternal().add(visit);
// visit.setPet(this);
// }
//
// }
