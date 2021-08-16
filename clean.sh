#/bin/bash

# removes all .class files
for dir in */; do
    cd $dir
    for file in *; do 
        if [ "${file: -6}" == ".class" ] 
        then
            rm $file
        fi
    done
    cd ..
done