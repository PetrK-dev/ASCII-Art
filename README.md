# ASCII Art

Příkaz pro spuštění:
run + @Loader(1) + @Filter(0..n) + @Exporter(1..n)

@Loader:

                   Načtení obrázku = --image "path"
               
    Vygenerování náhodného obrázku = --image-random


@Filter:

                            Invert = --invert

                        Světelnost = --brightness value

                         Přetočení = --flip axis

                     
@Export

                        Do souboru = --output-file "path"

                        Do konzole = --output-console