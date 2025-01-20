package ru.gb.springdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import ru.gb.springdemo.model.Reader;




public interface ReaderRepository extends JpaRepository<Reader, Long> {

  //private final List<Reader> readers;

  //public ReaderRepository() {
   // this.readers = new ArrayList<>();
  //}

  //@PostConstruct
  //public void generateData() {
  //  readers.addAll(List.of(
  //    new ru.gb.springdemo.model.Reader("Игорь")
  //  ));
  //}

//  public Reader getReaderById(long id) {
//    return readers.stream().filter(it -> Objects.equals(it.getId(), id))
//      .findFirst()
//      .orElse(null);
//  }
//
//    public Reader creatReader(String name) {
//      Reader reader = new Reader(name);
//      readers.add(reader);
//      return reader;
//    }
//
//  public void deleteReaderById(long id) {
//  }
//
//    public Reader[] getAllReaders() {
//      return (Reader[]) readers.stream()
//              .toArray(Reader[]::new);
//    }
}
