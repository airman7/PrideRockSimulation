#!/bin/sh
./gradlew fatJar
cat <<EOF > tmp.sh
#!/bin/sh
java -jar $1
EOF
chmod +x tmp.sh ; open -a Terminal tmp.sh ;


