

# tsconfig shcema

## Compliation Context
- compilation context is basically just a fancy term for grouping of the files that TypeScript will parse and analyze to determine what is valid and what is not
- Along with the information about which files, the compilation context contains information about which compiler options are in use
- A great way to define this logical grouping (we also like to use the term project) is using a tsconfig.json file

---

## tsconfig shcema
최상위 프로퍼티
- compileOnSave
- extends
- complieOptions
- files
- include
- exclude
- references
- typeAcquisition
- tsNode

---

### ComplieOnSave
```json
{
    "compileOnSaveDefinition": {
        "properties": {
            "compileOnSave": {
                "description" : "Enable Compile-on-Save for this project.",
                "type": "boolean"
                }
            }
        }
}

```
- true / false (default : false )
- 지원 
    - Visual Studio 2015with TypeScript 1.8.4 이상
    - atom-typescript 플러그인 

---

### Extends
```json
{
    "extends": "./base.json"
}

```

- 파일(상대) 경로명 : string
- TypeScript 2.1 New Spec
- 상속할 수 있는 설정들을 공식적으로 배포하고있다
    - npm install --save-dev @tsconfig/deno
    ```json
    {
        "extends": "@tsconfig/deno/tsconfig.json"
    }
    ```

---

### files, include, exclude 
#### 영문
- filesDefinition 
    - if not 'files' for 'include' property is present in a tsconfig.json the compiler defaults to including all files except those specified by 'exclude'
    - when a 'files' is specified, only those files and those specified by 'include' are included
- excludeDefinition 
    - specifies a list of fiels to be excluded from compilation 
    - 'exclude' property only affects the files included via the 'include' property and not the 'files' property 
- includeDefinition 
    - speicifies a list of glob patterns that match fiels to be included in compilation
    - no 'files' or 'include' property is present in a tsconfig.json, the compiler defaults to including all files in the containing directory and subdirectories except those sepcified by 'exclude'
 
#### 한글
- 설정이 지정되지 않으면 전부다 컴파일
- 'files'
    - 상대 혹은 절대 경로의 리스트 배열
    - exclude보다 우선된다
- 'include' & 'exclude'
    - glob패턴 (.gitignore 같은..)
    - 'include'
        - 'exclude' 보다 약하다
        - \* 같은걸 사용하면, .ts / .tsx / .d.ts만 include (allowJS 해야지만 js까지 compile)
    - 'exlude'
        - 설정 안하면 4가지(node_moduces, bower_components, jspm_packages, \<outDir>)를 default로 제외합니다
        - \<outDir>은 항상 제외합니다 ('include' 에 있어도)

---

### compileOptions 
- typeRoots
- types

.ts 파일에서 .js를 import해서 사용할 시에 type이 지정되지 않아서 오류가 발생한다.

```json
{
    "compileOption" : {
        "typeRoots": [
            "./node_modues/@types",
        ],
        "type": [
            "react",
        ],
}
```

- TypeScript 2.0 부터 사용 가능해진 내장 type definition 시스템
- 설정이 없으면 
    - node_modules/@types 라는 모든 경로를 찾아서 사용
- typeRoots 
    - 배열 안에 들어있는 경로들을 가져옵니다.
- types
    - 배열 안의 모듈 혹은 ./node_modules/@types/안의 모듈 이름에서 찾아옵니다.
    - [] 빈 배열을 넣는다는건 이시스템을 이용하지 않겠다는 뜻
- typeRoots 와 types를 같이 사용하진 않습니다.

---

### compileOptions 
- target
- lib

#### target
- set JavaScript language Version
- 빌드의 결과물을 어떤 버전으로 할것이냐 
- 지정하지 않으면 es3


#### lib 
- Specify a set of bundle library declaration files that describe the target funtime enviroment
- 기본 type definition 라이브러리를 어떤것을 사용할 것이냐 
- lib를 지정하지 않을떄
    - target 이 'es3' 이고, 디폴트로 lib.d.ts를 사용합니다.
    - target 이 'es5' 이면, 디폴트로 dom, es5, scripthost를 사용합니다 
    - target 이 'es6' 이면, 디폴트로 dom, es6, scripthost,  dom.iterable를 사용합니다.
- lib를 지정하면 그 lib 배열로만 라이브러리를 사용합니다. 
    - 빈 [] => 'no definition found 어쩌구'  error 

---

### compileOptions 
- outDir
- outFile
- rootDir 

#### outFile
- specifiy a file that bundles all outputs into one JavaScript file
- if 'declaration is true, also designates a file that bundles all .d.ts output
- If module is system or amd, all module files will also be concatenated into this file after all global content.
    - Note: outFile cannot be used unless module is None, System, or AMD. This option cannot be used to bundle CommonJS or ES6 modules.

#### outDir 
- specifiy an output folder for all emitted files 
- 컴파일된 파일들을 모아두는곳 
    - ex) .js

#### rootDir
- specifiy the root folder within your sources files 
- 프로잭트의 최상위 폴더를 지정
- rootDir 가 지정되지 않으면 컴파일되는 파일의  경로가 최상위 폴더로 지정됨

--- 

### Interface 

```ts
interface person {
    name: string
    age: number
}

function hello(person: person): void {
    console.log(`안녕하세요! ${person.name}입니다`)
}

const p1: person = {
    name: "spammy",
    age: 39,
}

hello(p1)
```
