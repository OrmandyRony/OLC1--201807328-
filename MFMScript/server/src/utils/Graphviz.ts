import { Digraph, Node, Edge, EdgeTargetTuple, attribute, toDot } from 'ts-graphviz';
import { CliRenderer } from "@diagrams-ts/graphviz-cli-renderer";

export class CDigraph extends Digraph {
  constructor(label: string) {
    super('G', {
      [attribute.label]: label,
    });
  }

  public async generate(){
    const render = CliRenderer({ outputFile: "./example.pdf", format: "pdf" });
    await (async () => {
        try {
          await render(
            toDot(this)
          );
        } catch (error) {
          console.log(error);
        }
    })();    
  }
}

export class CNode extends Node {
  constructor(id: number, label: string) {
    super(`node${id}`, {
      [attribute.label]: label
    });
  }
}

export class CEdge extends Edge {
  constructor(targets: EdgeTargetTuple, label: string) {
    super(targets, {
      [attribute.label]: label
    });
  }
}